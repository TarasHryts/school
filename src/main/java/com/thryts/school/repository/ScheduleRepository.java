package com.thryts.school.repository;

import com.thryts.school.entity.Day;
import com.thryts.school.entity.Grade;
import com.thryts.school.entity.Schedule;
import com.thryts.school.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByDayOfWeekAndGrade(Day day, Grade grade);

    List<Schedule> findAllByDayOfWeek(Day day);

    Optional<Schedule> findByScheduleId(Long scheduleId);
}
