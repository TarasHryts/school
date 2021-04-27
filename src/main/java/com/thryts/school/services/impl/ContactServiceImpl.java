package com.thryts.school.services.impl;

import com.thryts.school.dto.ContactDto;
import com.thryts.school.entity.Contact;
import com.thryts.school.repository.ContactRepository;
import com.thryts.school.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private final ContactRepository contactRepository;

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
    public List<Contact> loadContacts(List<Contact> contactList) {
        return contactRepository.saveAll(contactList);
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
