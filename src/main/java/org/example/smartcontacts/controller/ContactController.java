package org.example.smartcontacts.controller;

import lombok.RequiredArgsConstructor;
import org.example.smartcontacts.entity.Contact;
import org.example.smartcontacts.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<Contact> getContactById(@PathVariable long contactId) {
        Contact contact = contactService.getContactById(contactId);
        if (contact != null) {
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContact(@RequestBody Contact contact) {
        try {
            contactService.addContact(contact);
            return new ResponseEntity<>("Contact added successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateContact(@RequestBody Contact contact) {
        try {
            contactService.updateContact(contact);
            return new ResponseEntity<>("Contact updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable long contactId) {
        contactService.deleteContact(contactId);
        return new ResponseEntity<>("Contact deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Contact>> searchContacts(@RequestParam String keyword) {
        List<Contact> contacts = contactService.searchContacts(keyword);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }
}
