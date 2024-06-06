package com.example.schedulingService.services;

import com.example.schedulingService.entities.User;
import com.example.schedulingService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public String login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            // In a real application, use JWT or another token mechanism
            return UUID.randomUUID().toString();
        }
        return null;
    }
}