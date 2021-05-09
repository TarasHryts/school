package com.thryts.school.services.impl;

import com.thryts.school.entity.Grade;
import com.thryts.school.repository.GradeRepository;
import com.thryts.school.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Transactional
    @Override
    public List<Grade> loadGrades(String fileName) {
        BufferedReader reader = null;
        List<Grade> gradeList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                Grade grade = new Grade(splitLine[0], Integer.valueOf(splitLine[1]));
                gradeRepository.save(grade);
                gradeList.add(grade);
            }
            return gradeList;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return gradeList;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Grade> findGradeByGradeName(String gradeName) {
        return gradeRepository.findGradesByGradeName(gradeName);
    }
}
