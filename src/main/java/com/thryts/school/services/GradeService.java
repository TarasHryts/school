package com.thryts.school.services;

import com.thryts.school.entity.Grade;

import java.util.List;

public interface GradeService {
    List<Grade> loadGrades(List<Grade> gradeList);

    List<Grade> getAllGrades();
}
