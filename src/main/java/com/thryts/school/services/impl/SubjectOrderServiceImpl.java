package com.thryts.school.services.impl;

import com.thryts.school.entity.SubjectOrder;
import com.thryts.school.repository.SubjectOrderRepository;
import com.thryts.school.services.SubjectOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectOrderServiceImpl implements SubjectOrderService {
    private final SubjectOrderRepository subjectOrderRepository;

    @Autowired
    public SubjectOrderServiceImpl(SubjectOrderRepository subjectOrderRepository) {
        this.subjectOrderRepository = subjectOrderRepository;
    }

    @Override
    public Optional<SubjectOrder> createSessionOrdered(SubjectOrder subjectOrder) {
        return Optional.of(subjectOrderRepository.save(subjectOrder));
    }

    @Override
    public List<SubjectOrder> getAllSubjectOrdered() {
        return subjectOrderRepository.findAll();
    }
}
