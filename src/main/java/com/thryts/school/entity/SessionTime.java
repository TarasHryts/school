package com.thryts.school.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "session_time")
public class SessionTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_time_id")
    private Long sessionTimeId;
    @Column(name = "session_order", unique = true)
    private Long sessionOrder;
    @Column(name = "start_session")
    private LocalTime startSession;
    @Column(name = "end_session")
    private LocalTime endSession;

    public SessionTime(Long sessionOrder, LocalTime startSession, LocalTime endSession) {
        this.sessionOrder = sessionOrder;
        this.startSession = startSession;
        this.endSession = endSession;
    }
}
