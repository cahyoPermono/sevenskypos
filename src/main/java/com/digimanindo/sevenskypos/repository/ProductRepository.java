package com.digimanindo.sevenskypos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digimanindo.sevenskypos.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
