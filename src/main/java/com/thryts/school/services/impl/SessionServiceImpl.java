package com.thryts.school.services.impl;

import com.thryts.school.entity.*;
import com.thryts.school.repository.SessionRepository;
import com.thryts.school.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    private final ScheduleService scheduleService;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final DayService dayService;

    @Autowired
    public SessionServiceImpl(SessionRepository sessionRepository,
                              ScheduleService scheduleService,
                              StudentService studentService,
                              TeacherService teacherService,
                              DayService dayService) {
        this.sessionRepository = sessionRepository;
        this.scheduleService = scheduleService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.dayService = dayService;
    }

    @Override
    public List<Session> createSessions(LocalDate startDate, LocalDate endDate) {
        List<Session> sessionList = new ArrayList<>();
        for(LocalDate cursor = startDate; cursor.isBefore(endDate.plusDays(1)); cursor = cursor.plusDays(1)) {
            sessionList.addAll(createSessionDay(cursor));
        }
        return sessionList;
    }

    @Override
    public List<Session> createSessionDay(LocalDate currentDay) {
        List<Session> sessionList = new ArrayList<>();
        Day day = dayService.findByEngName(currentDay.getDayOfWeek().name()).get();
        List<Schedule> scheduleList = scheduleService.findAllByDayOfWeek(day);
        for (Schedule schedule : scheduleList) {
            createByScheduleAndDay(schedule, currentDay);
        }
        return sessionList;
    }

    @Override
    public List<Session> createByScheduleAndDay(Schedule schedule, LocalDate currentDay) {
        List<Session> sessionList = new ArrayList<>();
        Grade grade = schedule.getGrade();
        List<Student> studentList = studentService.getStudentByGrade(grade);
        List<SubjectOrder> subjectOrderList = schedule.getSubjectOrders();
        for (Student student : studentList) {
            for (SubjectOrder subjectOrder : subjectOrderList) {
                Teacher teacher = teacherService.getTeacherByGradeAndSubject(grade, subjectOrder.getSubject()).get();
                Session session = new Session(currentDay, subjectOrder.getSessionTime(),student,teacher,subjectOrder.getSubject());
                sessionList.add(session);
                sessionRepository.save(session);
            }
        }
        return  sessionList;
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }
}
