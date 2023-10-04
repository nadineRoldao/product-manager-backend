package com.nadine.productmanager.repository;

import com.nadine.productmanager.enums.ProductStatus;
import com.nadine.productmanager.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByStatus(ProductStatus status);

    Page<Product> findAllByStatus(ProductStatus status, Pageable pageable);

}
