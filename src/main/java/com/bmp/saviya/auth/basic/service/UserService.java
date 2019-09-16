package com.bmp.saviya.auth.basic.service;

import com.bmp.saviya.auth.basic.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
