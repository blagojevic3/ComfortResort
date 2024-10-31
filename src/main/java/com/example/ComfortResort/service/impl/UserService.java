package com.example.ComfortResort.service.impl;


import com.example.ComfortResort.model.User;
import com.example.ComfortResort.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;


    public User findByUsername(String username){

        Optional<User> user = userRepository.findFirstByUsername(username);
        if(!user.isEmpty()){
            return user.get();
        }
        return null;
    }

    public User register(User user) {

        if (userRepository.findFirstByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken");
        }

        // Encode the password before saving the user
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save and return the new user
        return userRepository.save(user);
    }




}
