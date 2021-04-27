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
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "study_day")
public class StudyDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_day_id")
    private Long studyDayId;
    @Column(name = "study_date")
    private LocalDate studyDate;
    @Column(name = "comment")
    private String comment;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "study_day_session",
        joinColumns = @JoinColumn(name = "study_day_id", referencedColumnName = "study_day_id"),
        inverseJoinColumns = @JoinColumn(name = "session_id", referencedColumnName = "session_id"))
    private Set<Session> sessions = new HashSet<>();
}
