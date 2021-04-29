package com.thryts.school.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Long classId;
    @Column(name = "grade_name")
    private String gradeName;
    @Column(name = "academic_level")
    private Integer academicLevel;
    @OneToMany(mappedBy = "grade")
    private Set<Student> students = new HashSet<>();

    public Grade(String gradeName, Integer academicLevel) {
        this.gradeName = gradeName;
        this.academicLevel = academicLevel;
    }
}
