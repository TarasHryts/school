package com.thryts.school.services;

import com.thryts.school.entity.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeService {
    List<Grade> loadGrades(String fileName);

    List<Grade> getAllGrades();

    Optional<Grade> findGradeByGradeName(String gradeName);
}
