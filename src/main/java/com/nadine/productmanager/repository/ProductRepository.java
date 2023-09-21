package com.nadine.productmanager.repository;

import com.nadine.productmanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
