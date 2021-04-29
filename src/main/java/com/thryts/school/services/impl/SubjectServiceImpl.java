package com.thryts.school.services.impl;

import com.thryts.school.entity.Subject;
import com.thryts.school.repository.SubjectRepository;
import com.thryts.school.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Transactional
    @Override
    public List<Subject> loadSubjects(List<Subject> subjectList) {
        return subjectRepository.saveAll(subjectList);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
