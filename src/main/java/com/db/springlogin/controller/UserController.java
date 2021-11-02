package com.db.springlogin.controller;

import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @PutMapping("/login")
    public void login(@RequestParam String user, String password){

    }

    @GetMapping("/anything")
    public String anything() {
        return ("<h1>wtv</h1>");
    }

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}
