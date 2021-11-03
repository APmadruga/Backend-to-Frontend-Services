package com.db.springlogin.service.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class InvoiceRS {
    private Long id;
    private Long number;
    private String name;
    private List<ProductRS> productRSList;
    private Long total;

}
