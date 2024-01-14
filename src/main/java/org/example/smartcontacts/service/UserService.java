package org.example.smartcontacts.service;

import org.example.smartcontacts.entity.User;

public interface UserService {
    void updateUser(User user);

    void deleteUser(long userId);

    void changePassword(long userId, String newPassword);

    boolean validateLogin(String username, String password);

    boolean isUsernameValid(String username);

    boolean isEmailValid(String email);
}