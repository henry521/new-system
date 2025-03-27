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
        return userRepository.findByUsername(user.getUsername())
                .filter(u -> u.getPassword().equals(user.getPassword()))
                .orElse(null);
    }
    
    public User register(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return null;
        }
        return userRepository.save(user);
    }
} 