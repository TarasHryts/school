//package com.thryts.school.entity;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Data
//@NoArgsConstructor
//@Table(name = "parent")
//public class Parent extends Contact{
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "student_parent",
//            joinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "contact_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "contact_id"))
//    private Set<Contact> students = new HashSet<>();
//
//
//    public Parent(String firstName, String lastName, String surName, Integer age, LocalDate birthDayDate, String email, String password) {
//        super(firstName, lastName, surName, age, birthDayDate, email, password);
//        this.students = students;
//    }
//}
