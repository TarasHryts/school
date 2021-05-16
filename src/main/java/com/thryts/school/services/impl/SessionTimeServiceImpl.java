package com.thryts.school.services.impl;

import com.thryts.school.entity.Day;
import com.thryts.school.entity.SessionTime;
import com.thryts.school.repository.SessionTimeRepository;
import com.thryts.school.services.SessionTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SessionTimeServiceImpl implements SessionTimeService {
    private final SessionTimeRepository sessionTimeRepository;

    @Autowired
    public SessionTimeServiceImpl(SessionTimeRepository sessionTimeRepository) {
        this.sessionTimeRepository = sessionTimeRepository;
    }

    @Override
    public List<SessionTime> loadSessionTime(String fileName) {
        BufferedReader reader = null;
        List<SessionTime> sessionTimes = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                SessionTime sessionTime = new SessionTime(Long.valueOf(splitLine[0]),
                        LocalTime.parse(splitLine[1]), LocalTime.parse(splitLine[2]));
                sessionTimeRepository.save(sessionTime);
                sessionTimes.add(sessionTime);
            }
            return sessionTimes;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return sessionTimes;
    }

    @Override
    public Optional<SessionTime> getSessionTimeByOrder(Long sessionOrder) {
        return sessionTimeRepository.getSessionTimeBySessionOrder(sessionOrder);
    }

    @Override
    public List<SessionTime> getAllSessionTimes() {
        return sessionTimeRepository.findAll();
    }
}
