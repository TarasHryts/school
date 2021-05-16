package com.thryts.school.repository;

import com.thryts.school.entity.SessionTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionTimeRepository extends JpaRepository<SessionTime, Long> {
    Optional<SessionTime> getSessionTimeBySessionOrder(Long sessionOrder);
}
