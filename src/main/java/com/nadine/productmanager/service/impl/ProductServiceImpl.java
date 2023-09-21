package com.nadine.productmanager.service.impl;

import com.nadine.productmanager.enums.OrderStatus;
import com.nadine.productmanager.enums.ProductCategory;
import com.nadine.productmanager.exceptions.BadRequestException;
import com.nadine.productmanager.exceptions.OrderNotFoundException;
import com.nadine.productmanager.exceptions.ProductNotFoundException;
import com.nadine.productmanager.model.Product;
import com.nadine.productmanager.repository.ProductRepository;
import com.nadine.productmanager.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
    }

    @Override
    public Product createProduct(Product product) {
        if (Objects.isNull(product)) {
            throw new BadRequestException("Os campos precisam ser informados");
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, String name, String category, Double price, String link) {
        var productCheck =  productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());

        productCheck.setName(name);
        productCheck.setCategory(ProductCategory.valueOf(category));
        productCheck.setPrice(price);
        productCheck.setLink(link);

        return productRepository.save(productCheck);
    }
}
