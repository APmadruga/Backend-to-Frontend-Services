package com.db.springlogin.service;


import com.db.springlogin.controller.requests.UserRQ;
import com.db.springlogin.model.User;
import com.db.springlogin.model.UserDetails;
import com.db.springlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(UserDetails::new).get();
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
