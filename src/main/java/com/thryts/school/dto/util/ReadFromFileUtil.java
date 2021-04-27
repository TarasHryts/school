package com.thryts.school.dto.util;

import com.thryts.school.entity.Contact;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileUtil {
 //order in .CSV file FirstName,LastName,SurName,Age,BirthDay,Email,Password
    public static List<Contact> readDataFromFile(String fileName) {
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
}
