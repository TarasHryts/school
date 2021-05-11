package com.thryts.school.services;

import com.thryts.school.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> loadTeacher(String fileName);

    List<Teacher> getAllTeachers();
}
