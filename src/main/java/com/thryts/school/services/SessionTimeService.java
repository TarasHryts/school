package com.thryts.school.services;

import com.thryts.school.entity.SessionTime;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;
import java.util.Optional;

public interface SessionTimeService {
    List<SessionTime> loadSessionTime(String fileName);

    Optional<SessionTime> getSessionTimeByOrder(Long sessionOrder);

    List<SessionTime> getAllSessionTimes();
}
