package com.thryts.school.services;

import com.thryts.school.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> loadSubjects(List<Subject> subjectList);

    List<Subject> getAllSubjects();
}
