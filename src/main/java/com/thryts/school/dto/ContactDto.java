package com.thryts.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private String firstName;
    private String lastName;
    private String surName;
    private Integer age;
    private LocalDate birthDayDate;
    private String email;
    private String password;
    private String passwordConfirm;
    private Boolean isActive;
    public ContactDto(String firstName, String lastName,
                      String surName, Integer age,
                      LocalDate birthDayDate, String email, Boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.age = age;
        this.birthDayDate = birthDayDate;
        this.email = email;
        this.isActive = isActive;
    }
}
