package com.db.springlogin.service.response;
import com.db.springlogin.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Setter
@AllArgsConstructor
public class ProductRS {
    private Long id;
    private Long value;
    private String name;

    //product as one invoice
    //@ManyToOne
    //private Invoice invoice;
    //private Long invoiceNum;
}
