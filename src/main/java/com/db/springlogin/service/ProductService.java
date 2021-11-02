package com.db.springlogin.service;

import com.db.springlogin.controller.requests.ProductRQ;
import com.db.springlogin.model.Product;
import com.db.springlogin.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRQ productRQ) {
        Long value = productRQ.getValue();
        String name = productRQ.getName();
        Product product = Product.
                builder()
                .name(name)
                .value(value)
                .build();
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
              return productRepository.findAll();
    }
}
