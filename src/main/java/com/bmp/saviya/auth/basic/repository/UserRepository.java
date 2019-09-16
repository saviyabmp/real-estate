package com.bmp.saviya.auth.basic.repository;

import com.bmp.saviya.auth.basic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
