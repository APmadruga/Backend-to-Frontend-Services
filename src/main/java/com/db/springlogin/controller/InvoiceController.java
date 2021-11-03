package com.db.springlogin.controller;
import com.db.springlogin.controller.requests.InvoiceRQ;
import com.db.springlogin.controller.requests.ProductRQ;
import com.db.springlogin.model.Invoice;
import com.db.springlogin.model.Product;
import com.db.springlogin.service.InvoiceService;
import com.db.springlogin.service.ProductService;
import com.db.springlogin.service.response.InvoiceRS;
import com.db.springlogin.service.response.ProductRS;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/invoices/{name}")
    public ResponseEntity<InvoiceRS> getInvoiceByName(String invoiceName){
        Invoice invoice = invoiceService.getInvoiceByName(invoiceName);
        Long number = invoice.getNumber();
        Long total = invoice.getTotal();
        List<Product> productList = invoice.getProductList();
        List<ProductRS> productRSList = new ArrayList<ProductRS>();
        for (Product product : productList) {
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
        Long invoiceId = invoice.getId();
        InvoiceRS invoiceRS = new InvoiceRS(
                invoiceId,
                number,
                invoiceName,
                productRSList,
                total
        );
        return ResponseEntity.ok(invoiceRS);
    }


    @ApiOperation(value = "Update registration detail",
            authorizations = { @Authorization(value="basicAuth") })
    @GetMapping("/invoices/{id}")
    public ResponseEntity<InvoiceRS> getInvoiceById(Long id){
        Invoice invoice = invoiceService.getInvoiceById(id);
        Long number = invoice.getNumber();
        Long total = invoice.getTotal();
        List<Product> productList = invoice.getProductList();
        List<ProductRS> productRSList = new ArrayList<ProductRS>();
        for (Product product : productList) {
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
        String invoiceName = invoice.getName();
        InvoiceRS invoiceRS = new InvoiceRS(
                id,
                number,
                invoiceName,
                productRSList,
                total
        );
        return ResponseEntity.ok(invoiceRS);
    }


    @GetMapping("/invoices")
    public ResponseEntity<List<InvoiceRS>> getInvoicesForUser(){
        List<Invoice> invoiceList = invoiceService.getInvoicesForUser();
        List<InvoiceRS> invoiceRSList = new ArrayList<>();
        Long allInvoicesTotal = 0L;
        for(Invoice invoice : invoiceList){
            Long id = invoice.getId();
            Long number = invoice.getNumber();
            Long total = invoice.getTotal();
            List<Product> productList = invoice.getProductList();
            List<ProductRS> productRSList = new ArrayList<ProductRS>();
            for (Product product : productList) {
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
            String invoiceName = invoice.getName();
            InvoiceRS invoiceRS = new InvoiceRS(
                id,
                number,
                invoiceName,
                productRSList,
                total
            );
            invoiceRSList.add(invoiceRS);
        }
        return ResponseEntity.ok(invoiceRSList);
    }

    @PostMapping(value = "/invoices")
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
        String invoiceName = invoice.getName();
        InvoiceRS invoiceRS = new InvoiceRS(
                id,
                number,
                invoiceName,
                productRSList,
                total
        );
        return ResponseEntity.ok(invoiceRS);
    }
}
