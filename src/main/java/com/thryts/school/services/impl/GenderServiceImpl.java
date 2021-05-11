package com.thryts.school.services.impl;

import com.thryts.school.entity.Gender;
import com.thryts.school.repository.GenderRepository;
import com.thryts.school.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {
    private final GenderRepository genderRepository;

    @Autowired
    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public List<Gender> loadGenders(String fileName) {
        BufferedReader reader = null;
        List<Gender> genderList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                Gender gender = new Gender(splitLine[0]);
                genderRepository.save(gender);
                genderList.add(gender);
            }
            return genderList;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return genderList;
    }

    @Override
    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }
}
