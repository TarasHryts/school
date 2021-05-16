package com.thryts.school.controller;

import com.thryts.school.entity.Day;
import com.thryts.school.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/day")
public class DayController {
    private final DayService dayService;

    @Autowired
    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @PostMapping("/load_days")
    public void load(@RequestParam String fileName) {
        dayService.loadDays(fileName);
    }

    @GetMapping("/all")
    public List<Day> getAllDays() {
        return dayService.getAllDays();
    }
}
