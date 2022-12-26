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

    @PostMapping("/products")
    public Product createProducts(@RequestBody Product product) {
        Long no = productService.join(product);
        return productService.findOne(no);
    }

    @PutMapping("/products/{no}")
    public Product updateProduct(@PathVariable Long no, @RequestBody ProductForm form) {
        Product product = productService.findOne(no);
        product.setName(form.getName());
        product.setPrice(form.getPrice());
        product.setStock(form.getStock());

        productService.update(product);

        return productService.findOne(no);
    }

    @DeleteMapping("/products/{no}")
    public void deleteProduct(@PathVariable Long no) {
        productService.delete(no);
    }
}
