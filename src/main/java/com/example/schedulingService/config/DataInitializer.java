package com.example.schedulingService.config;

import com.example.schedulingService.entities.User;
import com.example.schedulingService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");
            userRepository.save(user);
        }
    }
}
