package org.example.smartcontacts.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.smartcontacts.entity.User;
import org.example.smartcontacts.repository.UserRepository;
import org.example.smartcontacts.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void updateUser(User user) {
        if (isValidUser(user)) {
            userRepository.save(user);
        } else {
            // Xử lý khi thông tin người dùng không hợp lệ
            throw new IllegalArgumentException("Thông tin người dùng không hợp lệ");
        }
    }

    @Override
    public void deleteUser(long userId) {
        // Xóa thông tin người dùng khỏi cơ sở dữ liệu
        userRepository.deleteById(userId);
    }

    @Override
    public void changePassword(long userId, String newPassword) {
        // Kiểm tra tính hợp lệ của mật khẩu mới và xử lý logic thay đổi mật khẩu
        if (isPasswordValid(newPassword)) {
            userRepository.updatePasswordById(userId, newPassword);
        } else {
            // Xử lý khi mật khẩu mới không hợp lệ
            throw new IllegalArgumentException("Mật khẩu mới không hợp lệ");
        }
    }

    @Override
    public boolean validateLogin(String username, String password) {
        // Kiểm tra tính hợp lệ của thông tin đăng nhập
        // Trả về true nếu hợp lệ, ngược lại trả về false
        User user = userRepository.findByUsername(username).orElse(null);
        return user != null && user.getPassword().equals(password);
    }


    @Override
    public boolean isUsernameValid(String username) {
        // Kiểm tra tính hợp lệ của tên đăng nhập
        // Trả về true nếu hợp lệ, ngược lại trả về false
        return !userRepository.existsByUsername(username);
    }

    @Override
    public boolean isEmailValid(String email) {
        // Kiểm tra tính hợp lệ của email
        // Trả về true nếu hợp lệ, ngược lại trả về false
        // Xử lý khi email đã tồn tại
        return !userRepository.existsByEmail(email);
    }

    // Các phương thức hỗ trợ kiểm tra tính hợp lệ
    private boolean isValidUser(User user) {
        // Thực hiện các kiểm tra nhất định, ví dụ: kiểm tra không null, không rỗng, ...
        return user != null && user.getUsername() != null && !user.getUsername().isEmpty();
    }

    private boolean isPasswordValid(String password) {
        // Thực hiện các kiểm tra nhất định cho mật khẩu, ví dụ: độ dài, ký tự đặc biệt, ...
        return password != null && password.length() >= 6; // Ví dụ đơn giản, mật khẩu có ít nhất 6 ký tự
    }
}
