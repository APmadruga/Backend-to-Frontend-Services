package com.db.springlogin.controller;
import com.db.springlogin.controller.requests.ProductRQ;
import com.db.springlogin.model.Product;
import com.db.springlogin.service.InvoiceService;
import com.db.springlogin.service.response.ProductRS;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping(value = "/products")
    public ResponseEntity<List<ProductRS>> addProductsToInvoice(@RequestBody List<ProductRQ> productRQList){
        List<Product> productList = invoiceService.addProductsToInvoice(productRQList);
        //create loop to iterate productList , build and populate a new List<ProductRS> with that information
        return null;//ResponseEntity.ok(List<productRS>);
    }
}
