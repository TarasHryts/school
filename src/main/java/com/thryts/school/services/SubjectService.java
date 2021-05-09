package com.thryts.school.services;

import com.thryts.school.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> loadSubjects(String fileName);

    List<Subject> getAllSubjects();
}
