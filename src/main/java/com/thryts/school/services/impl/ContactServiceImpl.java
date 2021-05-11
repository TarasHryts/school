package com.thryts.school.services.impl;

import com.thryts.school.dto.ContactDto;
import com.thryts.school.entity.Contact;
import com.thryts.school.repository.ContactRepository;
import com.thryts.school.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional
    @Override
    public Optional<Contact> create(Contact contact) {
        Contact saveContact = contactRepository.save(contact);
        return Optional.ofNullable(saveContact);
    }

    @Override
    public List<Contact> loadContacts(String fileName) {
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
                contactRepository.save(contact);
                contactList.add(contact);
            }
            return contactList;
        } catch (IOException e) {
            //TODO add logger
            System.out.println("issue with read contacts from .CSV file");
        }
        return contactList;
    }

    @Transactional
    @Override
    public Optional<Contact> update(Long contactId, ContactDto contactDto) {
        Contact saveContact = contactRepository.findById(contactId).orElseThrow();
        saveContact.setFirstName(contactDto.getFirstName());
        saveContact.setLastName(contactDto.getLastName());
        saveContact.setSurName(contactDto.getSurName());
        saveContact.setEmail(contactDto.getEmail());
        saveContact.setAge(contactDto.getAge());
        saveContact.setBirthDayDate(contactDto.getBirthDayDate());
        saveContact.setPassword(contactDto.getPassword());
        return Optional.of(saveContact);
    }

    @Transactional
    @Override
    public Optional<Contact> updatePassword(Long contactId, String password, String passwordConfirm) {
        Contact saveContact = contactRepository.findById(contactId).orElseThrow();
        if (password.equals(passwordConfirm)) {
            saveContact.setPassword(password);
        }
        return Optional.of(saveContact);
    }

    @Transactional
    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Contact> getContactById(Long contactId) {
        return contactRepository.findById(contactId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
