package com.thryts.school.services.impl;

import com.thryts.school.entity.Subject;
import com.thryts.school.repository.SubjectRepository;
import com.thryts.school.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Transactional
    @Override
    public List<Subject> loadSubjects(String fileName) {
        BufferedReader reader = null;
        List<Subject> subjectList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                Subject subject = new Subject(splitLine[0], Integer.valueOf(splitLine[1]));
                subjectRepository.save(subject);
                subjectList.add(subject);
            }
            return subjectList;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return subjectList;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
