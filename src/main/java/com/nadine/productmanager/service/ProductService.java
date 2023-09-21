package com.nadine.productmanager.service;

import com.nadine.productmanager.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProduct(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, String name, String category, Double price, String link);

}
