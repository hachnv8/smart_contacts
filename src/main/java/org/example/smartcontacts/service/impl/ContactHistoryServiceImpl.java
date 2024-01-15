package org.example.smartcontacts.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.smartcontacts.entity.ContactHistory;
import org.example.smartcontacts.repository.ContactHistoryRepository;
import org.example.smartcontacts.service.ContactHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactHistoryServiceImpl implements ContactHistoryService {

    private final ContactHistoryRepository contactHistoryRepository;

    @Override
    public List<ContactHistory> getAllContactHistories() {
        return contactHistoryRepository.findAll();
    }

    @Override
    public List<ContactHistory> getContactHistoriesByContactId(long contactId) {
        return contactHistoryRepository.findByContactId(contactId);
    }

    @Override
    public void addContactHistory(ContactHistory contactHistory) {
        // Kiểm tra tính hợp lệ của thông tin lịch sử và xử lý logic thêm mới
        if (isValidContactHistory(contactHistory)) {
            contactHistoryRepository.save(contactHistory);
        } else {
            throw new IllegalArgumentException("Thông tin lịch sử liên lạc không hợp lệ");
        }
    }

    @Override
    public void updateContactHistory(ContactHistory contactHistory) {
        // Kiểm tra tính hợp lệ của thông tin cập nhật và xử lý logic cập nhật
        if (isValidContactHistory(contactHistory)) {
            contactHistoryRepository.save(contactHistory);
        } else {
            throw new IllegalArgumentException("Thông tin lịch sử liên lạc không hợp lệ");
        }
    }

    @Override
    public void deleteContactHistory(long contactHistoryId) {
        contactHistoryRepository.deleteById(contactHistoryId);
    }

    // Các phương thức hỗ trợ kiểm tra tính hợp lệ
    private boolean isValidContactHistory(ContactHistory contactHistory) {
        // Thực hiện các kiểm tra nhất định, ví dụ: kiểm tra không null, không rỗng, ...
        return contactHistory != null && contactHistory.getContactId() != null;
    }
}
