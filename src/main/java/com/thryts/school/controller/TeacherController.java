package com.thryts.school.controller;

import com.thryts.school.entity.Teacher;
import com.thryts.school.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/load_teachers")
    public void load(@RequestParam("fileName") String fileName) {
        teacherService.loadTeacher(fileName);
    }

    @GetMapping("/all")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
}
