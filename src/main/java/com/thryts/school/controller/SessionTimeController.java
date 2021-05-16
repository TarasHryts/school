package com.thryts.school.controller;

import com.thryts.school.entity.SessionTime;
import com.thryts.school.services.SessionTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session_time")
public class SessionTimeController {
    private final SessionTimeService sessionTimeService;

    @Autowired
    public SessionTimeController(SessionTimeService sessionTimeService) {
        this.sessionTimeService = sessionTimeService;
    }

    @PostMapping("/load_session_times")
    public void load(@RequestParam String fileName) {
        sessionTimeService.loadSessionTime(fileName);
    }

    @GetMapping("/all")
    public List<SessionTime> getAllSessionTimes() {
        return sessionTimeService.getAllSessionTimes();
    }

}
