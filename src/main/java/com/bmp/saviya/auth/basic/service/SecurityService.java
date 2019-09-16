package com.bmp.saviya.auth.basic.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
