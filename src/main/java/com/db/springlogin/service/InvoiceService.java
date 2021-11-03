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

import java.time.LocalDateTime;
import java.util.*;
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
        // It will generate 6 digit random Number.
        // from 0 to 999999
        int diaMes = LocalDateTime.now().getDayOfMonth();
        int numMes = LocalDateTime.now().getMonthValue();
        int hourNum = LocalDateTime.now().getHour();
        int minNum = LocalDateTime.now().getMinute();
        String str = "" + diaMes + numMes + hourNum + minNum;
        /* Random rnd = new Random();
        int randomNumber = rnd.nextInt(999999);
        Long.valueOf(randomNumber);*/
        // this will convert any number sequence into 6 character.
        Long number = Long.valueOf(str); //invoiceRQ.getNumber();
        String invoiceName = invoiceRQ.getName();
        final Long[] total = {0L};
        User user = userRepository.getById(2L);

        List<ProductRQ> productRQList= invoiceRQ.getProductRQList();

        List<Product> products = productRQList.stream()
                .map(it -> productRepository.findByName(it.getName()))
                .flatMap(Optional::stream)
                .map(x -> {
                    total[0] += x.getValue();
                    return x;
                })
                .collect(Collectors.toList());
        Long longTotal = total[0];
        Invoice invoice = Invoice
                .builder()
                .name(invoiceName)
                .number(number)
                .total(total[0])
                .user(user)
                .productList(products)
                .build();

        List<Invoice> invoiceList = new ArrayList<>();
        int productSize = products.size();
        for (int i = 0; i < productSize; i++) {
            invoiceList.add(invoice);
        }
        products.forEach(it -> it.setInvoice(invoiceList));

        invoiceRepository.save(invoice);
        productRepository.saveAll(products);


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

    public Invoice getInvoiceByName(String invoiceName) {
        try{
            return invoiceRepository.findByName(invoiceName).get();
        } catch (Exception e){
            throw new ResourceNotFound("Add a valid name to invoice");
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
