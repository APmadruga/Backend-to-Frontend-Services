package com.db.springlogin.controller.requests;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRQ {
    private String userName;
    private String password;
    private Long age;
}
