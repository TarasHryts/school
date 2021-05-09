package com.thryts.school.repository;

import com.thryts.school.entity.Grade;
import com.thryts.school.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByDayOfWeekAndGrade(String dayOfWeek, Grade grade);
}
