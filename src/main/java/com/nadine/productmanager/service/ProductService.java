package com.nadine.productmanager.service;

import com.nadine.productmanager.dto.ProductDTO;
import com.nadine.productmanager.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProducts();

    List<ProductDTO> getActiveProducts();

    Page<Product> getActiveProducts(Integer pageSize, Integer pageNumber);

    ProductDTO getProduct(Long id);

    ProductDTO createProduct(ProductDTO product);

    ProductDTO updateProduct(ProductDTO productDTO);

    void deleteProduct(Long id);

}
