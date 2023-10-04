package com.nadine.productmanager.service.impl;

import com.nadine.productmanager.enums.ProductStatus;
import com.nadine.productmanager.model.Product;
import com.nadine.productmanager.repository.ProductRepository;
import com.nadine.productmanager.service.ActivationService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivationServiceImpl implements ActivationService {

    private final ProductRepository productRepository;


    @Override
    @SneakyThrows
    public void activateProduct(Product product) {
        Thread.sleep(20_000);
        product.setStatus(ProductStatus.ACTIVE);
        productRepository.save(product);
    }
}
