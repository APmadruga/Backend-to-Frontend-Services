package com.db.springlogin.controller;
import com.db.springlogin.controller.requests.InvoiceRQ;
import com.db.springlogin.controller.requests.ProductRQ;
import com.db.springlogin.model.Invoice;
import com.db.springlogin.model.Product;
import com.db.springlogin.service.InvoiceService;
import com.db.springlogin.service.ProductService;
import com.db.springlogin.service.response.InvoiceRS;
import com.db.springlogin.service.response.ProductRS;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final ProductService productService;

    public InvoiceController(InvoiceService invoiceService, ProductService productService) {
        this.invoiceService = invoiceService;
        this.productService = productService;
    }
/*
    @GetMapping("/invoices")
    public ResponseEntity<List<InvoiceRS>> getUserInvoices(){
        List<Invoice> invoiceList =invoiceService.getUserInvoices();
        List<InvoiceRS> invoiceRSList = new ArrayList<InvoiceRS>();
        Long total = 0L;
        for(Invoice invoice: invoiceList){
            Long id = invoice.getId();
            Long number = invoice.getNumber();
            List<Product> productList = invoice.getProductList();
            List<ProductRS> productRSList = new ArrayList<ProductRS>();
            for (Product product : productList){
                Long productId = product.getId();
                Long value = product.getValue();
                String name = product.getName();
                ProductRS productRS = new ProductRS(productId, value, name);
                productRSList.add(productRS);
            }

            //List<ProductRS> productRSList = invoice.getProductList();
            //InvoiceRS invoiceRS = new InvoiceRS()
        }
        return
    }*/
    @PostMapping(value = "/invoice")
    public ResponseEntity<InvoiceRS> createInvoice(@RequestBody InvoiceRQ invoiceRQ){
        Invoice invoice = invoiceService.createInvoice(invoiceRQ);
        Long id = invoice.getId();
        Long number = invoice.getNumber();
        Long total = invoice.getTotal();

        List<Product> productList = invoice.getProductList();
        List<ProductRS> productRSList = new ArrayList<ProductRS>();
        for (Product product : productList){
            Long productId = product.getId();
            Long value = product.getValue();
            String name = product.getName();
            ProductRS productRS = new ProductRS(
                    productId,
                    value,
                    name
            );
            productRSList.add(productRS);
        }

        InvoiceRS invoiceRS = new InvoiceRS(
                id,
                number,
                productRSList,
                total
        );
        return ResponseEntity.ok(invoiceRS);
    }
}
