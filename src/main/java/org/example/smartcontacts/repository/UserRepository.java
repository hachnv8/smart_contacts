package org.example.smartcontacts.repository;

import jakarta.transaction.Transactional;
import org.example.smartcontacts.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Tìm kiếm người dùng theo tên đăng nhập
    Optional<User> findByUsername(String username);

    // Kiểm tra xem tên đăng nhập đã tồn tại chưa
    boolean existsByUsername(String username);

    // Kiểm tra xem địa chỉ email đã tồn tại chưa
    boolean existsByEmail(String email);

    @Transactional
    void updatePasswordById(Long userId, String newPassword);

}
