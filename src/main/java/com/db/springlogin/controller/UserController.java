package com.db.springlogin.controller;
import com.db.springlogin.controller.requests.UserRQ;
import com.db.springlogin.model.User;
import com.db.springlogin.service.US;
import com.db.springlogin.service.UserService;
import com.db.springlogin.service.response.UserRS;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController()
public class UserController {

    private final UserService userService;
    private final US us;

    public UserController(UserService userService, US us) {
        this.userService = userService;
        this.us = us;
    }

    @GetMapping("/user")
    public ResponseEntity<UserRS> getUserInformation(){
        User user = us.getUserInformation();
        Long id = user.getId();
        String userName = user.getUserName();
        String password = user.getPassword();
        Long age = user.getAge();
        UserRS userRS = new UserRS(
            id,
            userName,
            password,
            age
        );
        return ResponseEntity.ok(userRS);
    }

    @Transactional
    @PutMapping("/users")
    public ResponseEntity<UserRS> updateUser(@RequestBody UserRQ userRQ){
        User user = us.updateUser(userRQ);
        Long id = user.getId();
        String userName = user.getUserName();
        String password = user.getPassword();
        Long age = user.getAge();
        UserRS userRS = new UserRS(
                id,
                userName,
                password,
                age
        );
        return ResponseEntity.ok(userRS);
    }
}
