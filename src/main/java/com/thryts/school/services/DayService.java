package com.thryts.school.services;

import com.thryts.school.entity.Day;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface DayService {
    List<Day> loadDays(String fileName);

    List<Day> getAllDays();

    Optional<Day> findByName(String name, String nameEngShort, String nameUkr, String nameUkrShort);
}
