package com.thryts.school.services.impl;

import com.thryts.school.entity.Day;
import com.thryts.school.entity.Grade;
import com.thryts.school.entity.Schedule;
import com.thryts.school.entity.Subject;
import com.thryts.school.repository.DayRepository;
import com.thryts.school.repository.GradeRepository;
import com.thryts.school.repository.ScheduleRepository;
import com.thryts.school.repository.SubjectRepository;
import com.thryts.school.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final GradeRepository gradeRepository;
    private final SubjectRepository subjectRepository;
    private final DayRepository dayRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository,
                               GradeRepository gradeRepository,
                               SubjectRepository subjectRepository,
                               DayRepository dayRepository) {
        this.scheduleRepository = scheduleRepository;
        this.gradeRepository = gradeRepository;
        this.subjectRepository = subjectRepository;
        this.dayRepository = dayRepository;
    }

    @Override
    public List<Schedule> loadSchedule(String fineName) {
        BufferedReader reader = null;
        List<Schedule> subjectList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fineName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                Grade grade = gradeRepository.findGradesByGradeName(splitLine[2]).get();
                String dayName = splitLine[0].toLowerCase(Locale.ROOT);
                Day day = dayRepository
                        .findByNameEngOrNameEngShortOrNameUkrOrNameUkrShort(dayName, dayName, dayName, dayName).get();
                Schedule schedule = scheduleRepository.findByDayOfWeekAndGrade(day, grade)
                        .orElse(new Schedule(day));
                if (schedule.getGrade() == null) {
                    schedule.setGrade(gradeRepository.findGradesByGradeName(splitLine[2]).get());
                }
                List<Subject> subjects = schedule.getSubjects();
                Integer academicLevel = schedule.getGrade().getAcademicLevel();
                subjects.add(subjectRepository.findByNameAndAcademicLevel(splitLine[1], academicLevel).get());
                schedule.setSubjects(subjects);
                scheduleRepository.save(schedule);
                subjectList.add(schedule);
            }
            return subjectList;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return subjectList;
    }

    @Override
    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }
}
