package org.example.smartcontacts.repository;

import org.example.smartcontacts.entity.ContactGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactGroupRepository extends JpaRepository<ContactGroup, Long> {
}
