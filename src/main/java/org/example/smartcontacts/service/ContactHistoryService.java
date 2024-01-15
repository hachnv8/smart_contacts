package org.example.smartcontacts.service;
import org.example.smartcontacts.entity.ContactHistory;

import java.util.List;

public interface ContactHistoryService {

    List<ContactHistory> getAllContactHistories();

    List<ContactHistory> getContactHistoriesByContactId(long contactId);

    void addContactHistory(ContactHistory contactHistory);

    void updateContactHistory(ContactHistory contactHistory);

    void deleteContactHistory(long contactHistoryId);

    // Các phương thức tùy chỉnh khác nếu cần
}

