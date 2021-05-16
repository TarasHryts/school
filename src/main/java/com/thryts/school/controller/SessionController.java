package com.thryts.school.controller;

import com.thryts.school.entity.Session;
import com.thryts.school.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {
    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/create_sessions")
    public void createSession(@RequestParam String endDate,
                              @RequestParam String startDate) {
        sessionService.createSessions(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    @GetMapping("/all")
    public List<Session> getAllSessions(){
        return sessionService.getAllSessions();
    }
}
