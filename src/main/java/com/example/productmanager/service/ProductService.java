package com.example.productmanager.service;

import com.example.productmanager.domain.Product;
import com.example.productmanager.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Long join(Product product) {
        productRepository.save(product);
        return product.getNo();
    }

    public List<Product> findMembers() {
        return productRepository.findAll();
    }

}
