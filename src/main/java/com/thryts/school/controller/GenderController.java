package com.thryts.school.controller;

import com.thryts.school.entity.Gender;
import com.thryts.school.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gender")
public class GenderController {
    private final GenderService genderService;

    @Autowired
    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @PostMapping("/load_gender")
    public void load(@RequestParam String fileName) {
        genderService.loadGenders(fileName);
    }

    @GetMapping("/all")
    public List<Gender> getAllGenders() {
        return genderService.getAllGenders();
    }
}
