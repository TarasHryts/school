package com.thryts.school.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data@NoArgsConstructor
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long sessionId;
    @Column(name = "topic")
    private String topic;
    @Column(name = "mark")
    private Integer mark;
    @Column(name = "comment")
    private String comment;
    @Column(name = "session_date")
    private LocalDate sessionDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "session_time_id",referencedColumnName = "session_time_id")
    private SessionTime sessionTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "contact_id")
    private Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "contact_id")
    private Teacher teacher;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subject;

    public Session(LocalDate sessionDate,
                   SessionTime sessionTime,
                   Student student,
                   Teacher teacher,
                   Subject subject) {
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
        this.student = student;
        this.teacher = teacher;
        this.subject = subject;
    }
}
