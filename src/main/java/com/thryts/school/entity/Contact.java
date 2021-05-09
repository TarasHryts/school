package com.thryts.school.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contacts")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    protected Long contactId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "sur_name")
    private String surName;
    private Integer age;
    @Column(name = "birth_day")
    private LocalDate birthDayDate;
    private String email;
    private String password;
    @Column(name = "is_active")
    private Boolean isActive;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "contacts_roles",
            joinColumns = @JoinColumn(name = "contact_id", referencedColumnName = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "parent_student",
            joinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "contact_id"))
    private Set<Student> children;

    public Contact(String firstName, String lastName, String surName, Integer age, String email, Boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    public Contact(String firstName, String lastName, String surName, Integer age, LocalDate birthDayDate, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.age = age;
        this.birthDayDate = birthDayDate;
        this.email = email;
        this.password = password;
    }
}

