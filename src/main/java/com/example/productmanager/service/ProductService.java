package com.example.productmanager.service;

import com.example.productmanager.domain.Product;
import com.example.productmanager.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Long join(Product product) {
        productRepository.save(product);
        return product.getNo();
    }

    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public Product findOne(Long no) {
        return productRepository.findById(no).get();
    }

    @Transactional
    public void update(Product product) {
        Product productToBeUpdated = productRepository.findById(product.getNo()).get();
        productToBeUpdated.setName(product.getName());
        productToBeUpdated.setPrice(product.getPrice());
        productToBeUpdated.setStock(product.getStock());
        // productRepository.save(productRepository);
    }

    public void delete(Long no) {
        productRepository.delete(productRepository.findById(no).get());
    }

}
