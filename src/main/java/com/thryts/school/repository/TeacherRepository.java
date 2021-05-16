package com.thryts.school.repository;

import com.thryts.school.entity.Grade;
import com.thryts.school.entity.Subject;
import com.thryts.school.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
//    Optional<Teacher> getTeacherByGradesMatches(Grade grade);
//Optional<Teacher> getTeacherByGradesExistsAndSubjectsExists(Grade grade, Subject subject);
//    @Query(value = "select t.contactId from Teacher as t " +
//            "join Grade g on g.classId=t.grades" +
//            "where t.grades in (1?) and ")
//    Optional<Teacher> getTeacherByGradeAndSubject(Long gradeId, Long subjectId);
    Optional<Teacher> findByGradesAndSubjects(Grade grade, Subject subject);
}
