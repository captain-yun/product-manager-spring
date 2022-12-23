package com.example.productmanager.controller;

import com.example.productmanager.domain.Product;
import com.example.productmanager.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductApiController {

    private final ProductService productService;

    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> listProducts() {
        return productService.findProducts();
    }

//    @PostMapping("/products")
//    public Product postProducts() {
//
//    }

//    @PutMapping("/products/{no}")
//    public Product postProducts(@PathVariable Long no) {
//
//    }

//    @DeleteMapping("/products/{no}")
//    public Product postProducts(@PathVariable Long no) {
//
//    }
}
