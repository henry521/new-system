package com.myshop.service;

import com.myshop.model.User;
import com.myshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User login(User user) {
        return userRepository.findByEmail(user.getEmail())
                .filter(u -> u.getPassword().equals(user.getPassword()))
                .orElse(null);
    }
    
    public User register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return null;
        }
        return userRepository.save(user);
    }
} 