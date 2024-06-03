package com.code.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
