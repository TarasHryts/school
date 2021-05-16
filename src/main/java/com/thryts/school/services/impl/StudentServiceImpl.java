package com.thryts.school.services.impl;

import com.thryts.school.entity.Grade;
import com.thryts.school.entity.Student;
import com.thryts.school.repository.GradeRepository;
import com.thryts.school.repository.StudentRepository;
import com.thryts.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
    }

    @Transactional
    @Override
    public List<Student> loadStudents(String fileName) {
        BufferedReader reader = null;
        List<Student> studentList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                Student student = new Student(splitLine[0], splitLine[1], splitLine[2],
                        Integer.valueOf(splitLine[3]), LocalDate.parse(splitLine[4]),
                        splitLine[5], splitLine[6]);
                Grade grade = gradeRepository.findGradesByGradeName(splitLine[7]).get();
                student.setGrade(grade);
                studentRepository.save(student);
                studentList.add(student);
            }
            return studentList;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return studentList;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentByGrade(Grade grade) {
        return studentRepository.getStudentsByGrade(grade);
    }
}
