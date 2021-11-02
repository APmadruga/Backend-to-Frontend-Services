package com.db.springlogin.service;

import com.db.springlogin.controller.requests.ProductRQ;
import com.db.springlogin.model.Product;
import com.db.springlogin.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Product> addProductsToInvoice(List<ProductRQ> productRQList) {

        List<Product> productList = new ArrayList<Product>();
        for (int i = 0; i < productList.size(); i++){
            ProductRQ productRQ = productRQList.get(i);
            Long value;
            String productRQName;

            //productList.add(newProduct);
        }
        return null;
    }
}
