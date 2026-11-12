package com.csit321g5.securidy.securidy.repository;

import com.csit321g5.securidy.securidy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
