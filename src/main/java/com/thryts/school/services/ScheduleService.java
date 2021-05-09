package com.thryts.school.services;

import com.thryts.school.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> loadSchedule(String scheduleName);

    List<Schedule> getAllSchedule();
}
