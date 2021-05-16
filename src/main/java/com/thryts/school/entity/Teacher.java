package com.thryts.school.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher extends Contact{
    public Teacher(String firstName, String lastName, String surName, Integer age,
                   LocalDate birthDayDate, String email, String password) {
        super(firstName, lastName, surName, age, birthDayDate, email, password);
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_grade",
        joinColumns = @JoinColumn(name = "contact_id", referencedColumnName = "contact_id"),
        inverseJoinColumns = @JoinColumn(name = "grade_id", referencedColumnName = "grade_id"))
    private Set<Grade> grades = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_subject",
        joinColumns = @JoinColumn(name = "contact_id", referencedColumnName = "contact_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "subject_id"))
    private Set<Subject> subjects = new HashSet<>();
}
