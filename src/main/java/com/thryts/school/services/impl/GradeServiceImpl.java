package com.thryts.school.services.impl;

import com.thryts.school.entity.Grade;
import com.thryts.school.repository.GradeRepository;
import com.thryts.school.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Transactional
    @Override
    public List<Grade> loadGrades(List<Grade> gradeList) {
        return gradeRepository.saveAll(gradeList);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }
}
