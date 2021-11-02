package com.db.springlogin.controller.requests;

import com.db.springlogin.model.Invoice;

import javax.persistence.*;
import java.util.List;

public class UserRQ {
    private String userName;
    private String password;
    private Long age;
}
