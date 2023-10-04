package com.nadine.productmanager.adapter;

import com.nadine.productmanager.dto.ProductDTO;
import com.nadine.productmanager.enums.ProductCategory;
import com.nadine.productmanager.enums.ProductStatus;
import com.nadine.productmanager.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductAdapter {

    public ProductDTO convert(Product product) {
        ProductDTO finalProduct = new ProductDTO();

        BeanUtils.copyProperties(product, finalProduct);

        finalProduct.setCategory(product.getCategory().categoryDTOConverter());

        return finalProduct;
    }

    public Product convert(ProductDTO productDTO) {
        Product finalProduct = new Product();

        BeanUtils.copyProperties(productDTO, finalProduct);

        finalProduct.setStatus(ProductStatus.IN_PROGRESS);
        finalProduct.setCategory(ProductCategory.valueOf(productDTO.getCategory().description()));

        return finalProduct;
    }

}
