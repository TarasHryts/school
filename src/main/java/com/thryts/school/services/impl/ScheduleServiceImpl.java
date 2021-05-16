package com.thryts.school.services.impl;

import com.thryts.school.entity.*;
import com.thryts.school.repository.DayRepository;
import com.thryts.school.repository.GradeRepository;
import com.thryts.school.repository.ScheduleRepository;
import com.thryts.school.repository.SubjectRepository;
import com.thryts.school.services.ScheduleService;
import com.thryts.school.services.SessionTimeService;
import com.thryts.school.services.SubjectOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final GradeRepository gradeRepository;
    private final SubjectRepository subjectRepository;
    private final DayRepository dayRepository;
    private final SessionTimeService sessionTimeService;
    private final SubjectOrderService subjectOrderService;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository,
                               GradeRepository gradeRepository,
                               SubjectRepository subjectRepository,
                               DayRepository dayRepository,
                               SessionTimeService sessionTimeService,
                               SubjectOrderService subjectOrderService) {
        this.scheduleRepository = scheduleRepository;
        this.gradeRepository = gradeRepository;
        this.subjectRepository = subjectRepository;
        this.dayRepository = dayRepository;
        this.sessionTimeService = sessionTimeService;
        this.subjectOrderService = subjectOrderService;
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
                Grade grade = gradeRepository.findGradesByGradeName(splitLine[3]).get();
                String dayName = splitLine[0].toLowerCase(Locale.ROOT);
                Day day = dayRepository
                        .findByNameEngOrNameEngShortOrNameUkrOrNameUkrShort(dayName, dayName, dayName, dayName).get();
                Schedule schedule = scheduleRepository.findByDayOfWeekAndGrade(day, grade)
                        .orElse(new Schedule(day));
                if (schedule.getGrade() == null) {
                    schedule.setGrade(gradeRepository.findGradesByGradeName(splitLine[3]).get());
                }
                List<SubjectOrder> subjectOrderList = schedule.getSubjectOrders();
                Integer academicLevel = schedule.getGrade().getAcademicLevel();
                Subject subject = subjectRepository.findByNameAndAcademicLevel(splitLine[2], academicLevel).get();
                SessionTime sessionTime = sessionTimeService.getSessionTimeByOrder(Long.valueOf(splitLine[1])).get();
                SubjectOrder subjectOrder = new SubjectOrder(subject, sessionTime);
                subjectOrderService.createSessionOrdered(subjectOrder);
                subjectOrderList.add(subjectOrder);
                schedule.setSubjectOrders(subjectOrderList);
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

    @Override
    public List<Schedule> findAllByDayOfWeek(Day day) {
        return scheduleRepository.findAllByDayOfWeek(day);
    }

    @Override
    public Optional<Schedule> findScheduleById(Long scheduleId) {
        return scheduleRepository.findByScheduleId(scheduleId);
    }
}
