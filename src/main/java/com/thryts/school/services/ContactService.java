package com.thryts.school.services;

import com.thryts.school.dto.ContactDto;
import com.thryts.school.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Optional<Contact> create(Contact contact);

    List<Contact> loadContacts(List<Contact> contactList);

    Optional<Contact> update(Long contactId, ContactDto contactDto);

    Optional<Contact> updatePassword(Long contactId, String password, String passwordConfirm);

    void delete(Contact contact);

    Optional<Contact> getContactById(Long contactId);

    List<Contact> getAllContacts();
}
