package com.thryts.school.services.impl;

import com.thryts.school.entity.Day;
import com.thryts.school.entity.Role;
import com.thryts.school.repository.DayRepository;
import com.thryts.school.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DayServiceImpl implements DayService {
    private final DayRepository dayRepository;

    @Autowired
    public DayServiceImpl(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @Override
    public List<Day> loadDays(String fileName) {
        BufferedReader reader = null;
        List<Day> dayList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                Day day = new Day(splitLine[0], splitLine[1], splitLine[2], splitLine[3]);
                dayRepository.save(day);
                dayList.add(day);
            }
            return dayList;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return dayList;
    }

    @Override
    public List<Day> getAllDays() {
        return dayRepository.findAll();
    }

    @Override
    public Optional<Day> findByName(String name, String nameEngShort, String nameUkr, String nameUkrShort) {
        return dayRepository
                .findByNameEngOrNameEngShortOrNameUkrOrNameUkrShort(name, nameEngShort, nameUkr, nameUkrShort);
    }
}
