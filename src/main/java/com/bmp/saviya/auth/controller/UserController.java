package com.bmp.saviya.auth.controller;

import com.bmp.saviya.auth.model.User;
import com.bmp.saviya.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.time.LocalDateTime;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, Object> payload) throws Exception {

        Object username = payload.get("username");
        Object password = payload.get("password");
        Object email = payload.get("email");

        if (username != null && password != null && email != null) {
            User user = new User();
            user.setUsername(username.toString());
            user.setPassword(password.toString());
            user.setEmail(email.toString());
            LocalDateTime nowDateTime = LocalDateTime.now();
            user.setAccountCreated(nowDateTime);
            user.setAccountLastUpdated(nowDateTime);
            userService.save(user);
            return new ResponseEntity<>("{\"message\":\"User registered successfully\"}", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("{\"message\":\"Username, password and email cannot be empty\"}", HttpStatus.BAD_REQUEST);
        }
    }
}
