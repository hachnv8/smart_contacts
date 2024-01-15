package org.example.smartcontacts.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.smartcontacts.entity.ContactGroup;
import org.example.smartcontacts.repository.ContactGroupRepository;
import org.example.smartcontacts.service.ContactGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactGroupServiceImpl implements ContactGroupService {

    private final ContactGroupRepository contactGroupRepository;

    @Override
    public List<ContactGroup> getAllContactGroups() {
        return contactGroupRepository.findAll();
    }

    @Override
    public ContactGroup getContactGroupById(long contactGroupId) {
        return contactGroupRepository.findById(contactGroupId).orElse(null);
    }

    @Override
    public void addContactGroup(ContactGroup contactGroup) {
        // Kiểm tra tính hợp lệ của thông tin nhóm liên lạc và xử lý logic thêm mới
        if (isValidContactGroup(contactGroup)) {
            contactGroupRepository.save(contactGroup);
        } else {
            throw new IllegalArgumentException("Thông tin nhóm liên lạc không hợp lệ");
        }
    }

    @Override
    public void updateContactGroup(ContactGroup contactGroup) {
        // Kiểm tra tính hợp lệ của thông tin cập nhật và xử lý logic cập nhật
        if (isValidContactGroup(contactGroup)) {
            contactGroupRepository.save(contactGroup);
        } else {
            throw new IllegalArgumentException("Thông tin nhóm liên lạc không hợp lệ");
        }
    }

    @Override
    public void deleteContactGroup(long contactGroupId) {
        contactGroupRepository.deleteById(contactGroupId);
    }

    // Các phương thức hỗ trợ kiểm tra tính hợp lệ
    private boolean isValidContactGroup(ContactGroup contactGroup) {
        // Thực hiện các kiểm tra nhất định, ví dụ: kiểm tra không null, không rỗng, ...
        return contactGroup != null && contactGroup.getGroupName() != null && !contactGroup.getGroupName().isEmpty();
    }
}
