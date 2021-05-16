package com.thryts.school.services;

import com.thryts.school.entity.Schedule;
import com.thryts.school.entity.Session;

import java.time.LocalDate;
import java.util.List;

public interface SessionService {
    List<Session> createSessions(LocalDate startDate, LocalDate endDate);

    List<Session> createSessionDay(LocalDate currentDay);

    List<Session> createByScheduleAndDay(Schedule schedule, LocalDate currentDay);

    List<Session> getAllSessions();
}
