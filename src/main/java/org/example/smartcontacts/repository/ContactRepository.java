package org.example.smartcontacts.repository;

import org.example.smartcontacts.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByContactNameContainingIgnoreCase(String name);
}
