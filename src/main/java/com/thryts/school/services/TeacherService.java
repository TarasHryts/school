package com.thryts.school.services;

import com.thryts.school.entity.Grade;
import com.thryts.school.entity.Subject;
import com.thryts.school.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> loadTeacher(String fileName);

    List<Teacher> getAllTeachers();

    Optional<Teacher> getTeacherByGradeAndSubject(Grade grade, Subject subject);
}
