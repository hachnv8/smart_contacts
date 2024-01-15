package org.example.smartcontacts.service;

import org.example.smartcontacts.entity.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAllContacts();

    Contact getContactById(long contactId);

    void addContact(Contact contact);

    void updateContact(Contact contact);

    void deleteContact(long contactId);

    List<Contact> searchContacts(String keyword);

    // Các phương thức tùy chỉnh khác nếu cần
}
