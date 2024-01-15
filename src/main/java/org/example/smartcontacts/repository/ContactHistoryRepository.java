package org.example.smartcontacts.repository;

import org.example.smartcontacts.entity.ContactHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactHistoryRepository extends JpaRepository<ContactHistory, Long> {
    List<ContactHistory> findByContactId(long contactId);
}
