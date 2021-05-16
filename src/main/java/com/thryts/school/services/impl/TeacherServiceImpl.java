package com.thryts.school.services.impl;

import com.thryts.school.entity.Contact;
import com.thryts.school.entity.Grade;
import com.thryts.school.entity.Subject;
import com.thryts.school.entity.Teacher;
import com.thryts.school.repository.GradeRepository;
import com.thryts.school.repository.SubjectRepository;
import com.thryts.school.repository.TeacherRepository;
import com.thryts.school.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final GradeRepository gradeRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository,
                              GradeRepository gradeRepository,
                              SubjectRepository subjectRepository) {
        this.teacherRepository = teacherRepository;
        this.gradeRepository = gradeRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Teacher> loadTeacher(String fileName) {
        BufferedReader reader = null;
        List<Teacher> teachers = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                Teacher teacher = new Teacher(splitLine[0], splitLine[1], splitLine[2],
                        Integer.valueOf(splitLine[3]), LocalDate.parse(splitLine[4]),
                        splitLine[5], splitLine[6]);
                Grade grade = gradeRepository.findGradesByGradeName(splitLine[7]).get();
                Subject subject = subjectRepository
                        .findByNameAndAcademicLevel(splitLine[8], grade.getAcademicLevel()).get();
                Set<Grade> gradeSet = teacher.getGrades();
                gradeSet.add(grade);
                teacher.setGrades(gradeSet);
                Set<Subject> subjectSet = teacher.getSubjects();
                subjectSet.add(subject);
                teacher.setSubjects(subjectSet);
                teacherRepository.save(teacher);
                teachers.add(teacher);
            }
            return teachers;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return teachers;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> getTeacherByGradeAndSubject(Grade grade, Subject subject) {
        return teacherRepository.findByGradesAndSubjects(grade, subject);
    }
}
