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

    public List<Product> findMembers() {
        return productRepository.findAll();
    }

    public Product findOne(Long no) {
        return productRepository.findById(no).get();
    }

    @Transactional
    public void update(Product product) {
        Product ProductToBeUpdated = productRepository.findById(product.getNo()).get();
        ProductToBeUpdated.setName(product.getName());
        ProductToBeUpdated.setPrice(product.getPrice());
        ProductToBeUpdated.setStock(product.getStock());
    }

    public void delete(Long no) {
        productRepository.delete(productRepository.findById(no).get());
    }

}
