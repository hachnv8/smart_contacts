package org.example.smartcontacts.service;
import org.example.smartcontacts.entity.ContactGroup;

import java.util.List;

public interface ContactGroupService {

    List<ContactGroup> getAllContactGroups();

    ContactGroup getContactGroupById(long contactGroupId);

    void addContactGroup(ContactGroup contactGroup);

    void updateContactGroup(ContactGroup contactGroup);

    void deleteContactGroup(long contactGroupId);

    // Các phương thức tùy chỉnh khác nếu cần
}

