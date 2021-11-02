package com.db.springlogin.controller.requests;

import com.db.springlogin.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRQ {
    private String userName;
    private String password;
    private Long age;
}
