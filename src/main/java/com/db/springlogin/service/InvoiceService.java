package com.db.springlogin.service;
import com.db.springlogin.controller.requests.InvoiceRQ;
import com.db.springlogin.controller.requests.ProductRQ;
import com.db.springlogin.exception.ResourceNotFound;
import com.db.springlogin.model.Invoice;
import com.db.springlogin.model.Product;
import com.db.springlogin.model.User;
import com.db.springlogin.repository.InvoiceRepository;
import com.db.springlogin.repository.ProductRepository;
import com.db.springlogin.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
    public Invoice createInvoice(InvoiceRQ invoiceRQ) {
        Long number = invoiceRQ.getNumber();
        Long total = 0L;
        User user = userRepository.getById(2L);

        List<ProductRQ> productRQList= invoiceRQ.getProductRQList();
        List<Product> allProducts = productRepository.findAll();
        Map<String, Long> productsNameAndIds = new HashMap<>();
        List<String> allProductsNames = allProducts.stream().map(x -> {
            productsNameAndIds.put(x.getName(), x.getId());
            return x.getName();
        }).collect(Collectors.toList());

        List<Product> productList = new ArrayList<>();
        for (ProductRQ productRQ: productRQList) {
            String productRQName = productRQ.getName();
            boolean nameExists = false;
            nameExists = allProductsNames.stream().filter(x -> x == productRQName).collect(Collectors.toList()).size() >= 1;
            if(nameExists){
                throw new ResourceNotFound("You need to add an Existing Product");
            }
            Long productId = productsNameAndIds.get(productRQName);
            Product product = productRepository.getById(productId);
            productList.add(product);
            total += product.getValue();
        }

        Invoice invoice = Invoice
                .builder()
                .number(number)
                .total(total)
                .user(user)
                .productList(productList)
                .build();
        invoiceRepository.save(invoice);
        return invoice;
    }

    public List<Invoice> getInvoicesForUser() {
        //User is always the same
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        try{
            return invoiceRepository.findById(id).get();
        }catch (Exception e){
            throw new ResourceNotFound("Invoice Not Found");
        }
    }

/*    public List<Product> addProductsToInvoice(List<ProductRQ> productRQList) {

        List<Product> productList = new ArrayList<Product>();
        for (int i = 0; i < productList.size(); i++){
            ProductRQ productRQ = productRQList.get(i);
            Long value;
            String productRQName;

            //productList.add(newProduct);
        }
        return null;
    }*/
}
