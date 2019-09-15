package com.bmp.saviya.auth.service;

import com.bmp.saviya.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
