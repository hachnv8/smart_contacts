package org.example.smartcontacts.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.smartcontacts.entity.Contact;
import org.example.smartcontacts.repository.ContactRepository;
import org.example.smartcontacts.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(long contactId) {
        return contactRepository.findById(contactId).orElse(null);
    }

    @Override
    public void addContact(Contact contact) {
        // Kiểm tra tính hợp lệ của thông tin liên lạc và xử lý logic thêm mới
        if (isValidContact(contact)) {
            contactRepository.save(contact);
        } else {
            throw new IllegalArgumentException("Thông tin liên lạc không hợp lệ");
        }
    }

    @Override
    public void updateContact(Contact contact) {
        // Kiểm tra tính hợp lệ của thông tin cập nhật và xử lý logic cập nhật
        if (isValidContact(contact)) {
            contactRepository.save(contact);
        } else {
            throw new IllegalArgumentException("Thông tin liên lạc không hợp lệ");
        }
    }

    @Override
    public void deleteContact(long contactId) {
        contactRepository.deleteById(contactId);
    }

    @Override
    public List<Contact> searchContacts(String keyword) {
        // Giả sử bạn muốn tìm kiếm theo tên liên lạc
        return contactRepository.findByContactNameContainingIgnoreCase(keyword);
    }

    // Các phương thức hỗ trợ kiểm tra tính hợp lệ
    private boolean isValidContact(Contact contact) {
        // Thực hiện các kiểm tra nhất định, ví dụ: kiểm tra không null, không rỗng, ...
        return contact != null && contact.getContactName() != null && !contact.getContactName().isEmpty();
    }
}
