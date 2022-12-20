package com.example.productmanager.repository;

import com.example.productmanager.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataProductRepository
        extends JpaRepository<Product, Long>
        , ProductRepository
{

}
