package com.db.springlogin.controller.requests;

import com.db.springlogin.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRQ {
    private Long value;
    private String name;

    //product as one invoice
}
