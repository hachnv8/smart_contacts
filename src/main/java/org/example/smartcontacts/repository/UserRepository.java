package org.example.smartcontacts.repository;

import org.example.smartcontacts.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Modifying
    @Query("UPDATE User u SET u.password = :newPassword WHERE u.id = :userId")
    void updatePasswordById(@Param("userId") long userId, @Param("newPassword") String newPassword);

    // Các phương thức tìm kiếm hoặc tùy chỉnh khác nếu cần

}
