package com.db.springlogin.controller;

import com.db.springlogin.controller.requests.ProductRQ;
import com.db.springlogin.model.Product;
import com.db.springlogin.service.ProductService;
import com.db.springlogin.service.response.ProductRS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductRS>createProduct(@RequestBody ProductRQ productRQ){
        Product product = productService.createProduct(productRQ);
        Long id = product.getId();
        Long value = product.getValue();
        String name = product.getName();
        ProductRS productRS = new ProductRS(id, value,name);
        return ResponseEntity.ok(productRS);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductRS>> getProducts(){
        List<Product> productList = productService.getProducts();
        List<ProductRS> productRSList = new ArrayList<ProductRS>();
        for(int i = 0; i < productList.size(); i++){
            Product product = productList.get(i);
            Long id = product.getId();
            Long value = product.getValue();
            String name = product.getName();
            ProductRS productRS = new ProductRS(id, value, name);
            productRSList.add(productRS);
        }
        return ResponseEntity.ok(productRSList);
    }

    //getproductById
}

