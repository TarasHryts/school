package com.thryts.school.dto.util;

import com.thryts.school.entity.Contact;
import com.thryts.school.entity.Grade;
import com.thryts.school.entity.Role;
import com.thryts.school.entity.Subject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileUtil {
 //order in .CSV file FirstName,LastName,SurName,Age,BirthDay,Email,Password
    public static List<Contact> readContactListFromFile(String fileName) {
        BufferedReader reader = null;
        List<Contact> contactList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                Contact contact = new Contact(splitLine[0], splitLine[1], splitLine[2],
                        Integer.valueOf(splitLine[3]), LocalDate.parse(splitLine[4]),
                        splitLine[5], splitLine[6]);
                contactList.add(contact);
            }
            return contactList;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return contactList;
    }

    public static List<Grade> readGradesListFromFIle(String fileName) {
        BufferedReader reader = null;
        List<Grade> gradeList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                Grade grade = new Grade(splitLine[0], Integer.valueOf(splitLine[1]));
                gradeList.add(grade);
            }
            return gradeList;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return gradeList;
    }

    public static List<Role> readRolesListFromFIle(String fileName) {
        BufferedReader reader = null;
        List<Role> roleList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                Role role = new Role(splitLine[0]);
                roleList.add(role);
            }
            return roleList;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return roleList;
    }

    public static List<Subject> readSubjectsListFromFIle(String fileName) {
        BufferedReader reader = null;
        List<Subject> subjectList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(","); //can be other separator for example ";"
                Subject subject = new Subject(splitLine[0], Integer.valueOf(splitLine[1]));
                subjectList.add(subject);
            }
            return subjectList;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return subjectList;
    }
}
