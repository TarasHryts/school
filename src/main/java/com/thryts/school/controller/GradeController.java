package com.thryts.school.controller;

import com.thryts.school.entity.Grade;
import com.thryts.school.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {
    private GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping("/load_grades")
    public void load(@RequestParam String fileName) {
        gradeService.loadGrades(fileName);
    }

    @GetMapping("/all")
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }
}
