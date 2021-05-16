package com.thryts.school.repository;

import com.thryts.school.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DayRepository extends JpaRepository<Day, Long> {
    Optional<Day> findByNameEngOrNameEngShortOrNameUkrOrNameUkrShort(String name, String nameEngShort,
                                                                     String nameUkr, String nameUkrShort);
    Optional<Day> findByNameEng(String nameEng);
}
