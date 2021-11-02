package com.db.springlogin.service;

import com.db.springlogin.controller.requests.UserRQ;
import com.db.springlogin.model.User;
import com.db.springlogin.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class US {
    private final UserRepository userRepository;

    public US(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserInformation(){
        return userRepository.findById(2L).get();
    }

    public User updateUser(UserRQ userRQ) {
        User user = userRepository.findById(2L).get();
        String userName = user.getUserName();
        String password = user.getPassword();
        Long age = user.getAge();
        return userRepository.save(user);
    }
}
