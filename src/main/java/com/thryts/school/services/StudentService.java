package com.thryts.school.services;

import com.thryts.school.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> loadStudents(String fileName);

    List<Student> getAllStudents();
}
