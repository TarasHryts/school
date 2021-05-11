package com.thryts.school.services.impl;

import com.thryts.school.entity.Teacher;
import com.thryts.school.repository.TeacherRepository;
import com.thryts.school.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> loadTeacher(String fileName) {
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return null;
    }
}
