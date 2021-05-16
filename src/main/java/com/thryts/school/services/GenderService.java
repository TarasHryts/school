package com.thryts.school.services;

import com.thryts.school.entity.Gender;

import java.util.List;

public interface GenderService {
    List<Gender> loadGenders(String fileName);

    List<Gender> getAllGenders();
}
