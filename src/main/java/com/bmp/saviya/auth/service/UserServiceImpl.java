package com.bmp.saviya.auth.service;

import com.bmp.saviya.auth.model.User;
import com.bmp.saviya.auth.repository.RoleRepository;
import com.bmp.saviya.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        String passwordSalt = generatePasswordSalt();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword() + passwordSalt));
        user.setPasswordSalt(passwordSalt);
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Bean
    public BCryptPasswordEncoder userDetailsService() {
        return new BCryptPasswordEncoder();
    }

    private String generatePasswordSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
