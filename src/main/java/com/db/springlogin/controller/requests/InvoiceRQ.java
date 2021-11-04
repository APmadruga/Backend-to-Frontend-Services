package com.db.springlogin.controller.requests;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRQ {
    private String name;
    private List<ProductRQ> productRQList;
}
