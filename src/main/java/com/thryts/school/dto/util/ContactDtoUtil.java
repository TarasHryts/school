package com.thryts.school.dto.util;

import com.thryts.school.dto.ContactDto;
import com.thryts.school.entity.Contact;

public class ContactDtoUtil {
    public static Contact createContactFromDto(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setFirstName(contactDto.getFirstName());
        contact.setLastName(contactDto.getLastName());
        contact.setSurName(contactDto.getSurName());
        contact.setEmail(contactDto.getEmail());
        contact.setAge(contactDto.getAge());
        contact.setBirthDayDate(contactDto.getBirthDayDate());
        contact.setPassword(contactDto.getPassword());
        contact.setIsActive(contactDto.getIsActive());
        return contact;
    }
}
