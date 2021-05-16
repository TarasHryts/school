package com.thryts.school.services;

import com.thryts.school.entity.Day;
import com.thryts.school.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    List<Schedule> loadSchedule(String scheduleName);

    List<Schedule> getAllSchedule();

    List<Schedule> findAllByDayOfWeek(Day day);

    Optional<Schedule> findScheduleById(Long scheduleId);
}
