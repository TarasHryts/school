package com.thryts.school.repository;

import com.thryts.school.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    public Optional<Grade> findGradesByGradeName(String gradeName);
}
