package com.thryts.school.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student")
public class Student extends Contact {
    public Student(String firstName, String lastName, String surName, Integer age,
                   LocalDate birthDayDate, String email, String password) {
        super(firstName, lastName, surName, age, birthDayDate, email, password);
    }
    @Column(name = "sex")
    private String sex;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grade_id", referencedColumnName = "grade_id")
    private Grade grade;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_parent",
        joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "contact_id"),
        inverseJoinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "contact_id"))
    private Set<Contact> parents = new HashSet<>();

}
