package com.thryts.school.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "day")
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "day_id")
    private Long dayId;
    @Column(name = "name_eng", unique = true)
    private String nameEng;
    @Column(name = "name_eng_short", unique = true)
    private String nameEngShort;
    @Column(name = "name_ukr", unique = true)
    private String nameUkr;
    @Column(name = "name_ukr_short", unique = true)
    private String nameUkrShort;

    public Day(String nameEng, String nameEngShort, String nameUkr, String nameUkrShort) {
        this.nameEng = nameEng;
        this.nameEngShort = nameEngShort;
        this.nameUkr = nameUkr;
        this.nameUkrShort = nameUkrShort;
    }
}
