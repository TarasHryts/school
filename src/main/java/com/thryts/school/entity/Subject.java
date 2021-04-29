package com.thryts.school.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "subject")
public class Subject {

    public Subject(String name, Integer academicLevel) {
        this.name = name;
        this.academicLevel = academicLevel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;
    @Column(name = "name")
    private String name;
    @Column(name = "academic_level")
    private Integer academicLevel;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "subject_grade",
        joinColumns = @JoinColumn(name = "subject_id",referencedColumnName = "subject_id"),
        inverseJoinColumns = @JoinColumn(name = "grade_id", referencedColumnName = "grade_id"))
    private Set<Grade> grades = new HashSet<>();
}
