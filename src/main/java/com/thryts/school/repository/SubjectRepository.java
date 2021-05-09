package com.thryts.school.repository;

import com.thryts.school.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    public Optional<Subject> findByNameAndAcademicLevel(String subjectName, Integer academicLevel);
}
