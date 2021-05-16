package com.thryts.school.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "subject_ordered")
public class SubjectOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_ordered_id")
    private Long subject_ordered_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subject;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "session_time_id", referencedColumnName = "session_time_id")
    private SessionTime sessionTime;

    public SubjectOrder(Subject subject, SessionTime sessionTime) {
        this.subject = subject;
        this.sessionTime = sessionTime;
    }
}
