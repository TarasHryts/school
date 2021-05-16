package com.thryts.school.repository;

import com.thryts.school.entity.Grade;
import com.thryts.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getStudentsByGrade(Grade grade);
}
