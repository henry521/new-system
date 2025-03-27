package com.myshop.controller;

import com.myshop.model.User;
import com.myshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User loggedInUser = userService.login(user);
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User registeredUser = userService.register(user);
        if (registeredUser != null) {
            return ResponseEntity.ok(registeredUser);
        }
        return ResponseEntity.badRequest().body("Username already exists");
    }
} 