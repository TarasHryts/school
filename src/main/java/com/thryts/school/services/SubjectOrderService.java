package com.thryts.school.services;

import com.thryts.school.entity.SubjectOrder;

import java.util.List;
import java.util.Optional;

public interface SubjectOrderService {
    Optional<SubjectOrder> createSessionOrdered(SubjectOrder subjectOrder);

    List<SubjectOrder> getAllSubjectOrdered();
}
