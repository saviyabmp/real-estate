package com.bmp.saviya.auth.web;

import com.bmp.saviya.auth.model.User;
import com.bmp.saviya.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.hibernate.exception.ConstraintViolationException;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity registerUser(@RequestBody Map<String, Object> payload) throws Exception {

        Object username = payload.get("username");
        Object password = payload.get("password");

        if (username != null && password != null ) {
            User user = new User();
            user.setUsername(username.toString());
            user.setPassword(password.toString());
            userService.save(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("username and password cannot be empty", HttpStatus.BAD_REQUEST);
        }
    }
}
