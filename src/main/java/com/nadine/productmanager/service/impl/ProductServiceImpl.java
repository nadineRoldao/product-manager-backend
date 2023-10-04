package com.nadine.productmanager.service.impl;

import com.nadine.productmanager.adapter.ProductAdapter;
import com.nadine.productmanager.client.ProductManagerValidatorClient;
import com.nadine.productmanager.config.ProductActivationQueueConfig;
import com.nadine.productmanager.dto.ProductDTO;
import com.nadine.productmanager.enums.ProductCategory;
import com.nadine.productmanager.enums.ProductStatus;
import com.nadine.productmanager.exceptions.BadRequestException;
import com.nadine.productmanager.exceptions.ProductNotFoundException;
import com.nadine.productmanager.jms.ProductActivationPublisher;
import com.nadine.productmanager.model.Product;
import com.nadine.productmanager.repository.ProductRepository;
import com.nadine.productmanager.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.nadine.productmanager.config.ProductActivationQueueConfig.EXCHANGE;
import static com.nadine.productmanager.config.ProductActivationQueueConfig.KEY;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductManagerValidatorClient productManagerValidatorClient;
    private final ProductActivationPublisher publisher;
    private final ProductRepository productRepository;
    private final ProductAdapter productAdapter;

    @Override
    public List<ProductDTO> getProducts() {
        List<ProductDTO> products = new ArrayList<>();

        productRepository.findAll().forEach(product -> {
            products.add(productAdapter.convert(product));
        });

        return products;
    }

    @Override
    public List<ProductDTO> getActiveProducts() {
        List<ProductDTO> products = new ArrayList<>();

        productRepository.findAllByStatus(ProductStatus.ACTIVE).forEach(product -> {
            products.add(productAdapter.convert(product));
        });

        return products;
    }

    @Override
    public Page<Product> getActiveProducts(Integer pageSize, Integer pageNumber) {
        pageNumber--;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAllByStatus(ProductStatus.ACTIVE, pageable);
    }

    @Override
    @SneakyThrows
    @Cacheable("productId")
    public ProductDTO getProduct(Long id) {
        var product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());

        Thread.sleep(2000);

        return productAdapter.convert(product);
    }

    @Override
    @SneakyThrows
    public ProductDTO createProduct(ProductDTO productDTO) {
        if (Objects.isNull(productDTO)) {
            throw new BadRequestException("Os campos precisam ser informados");
        }

        // antes de salvar o produto, verificamos se ele é válido
        // recuperamos o retorno do metodo validateProduct da productManagerValidatorClient
        var productValidation = productManagerValidatorClient.validateProduct(productDTO);

        // se o campo isValid for falso então lança a exception recuperando e exibindo a mensagem que vem da api
        if (!productValidation.getIsValid()) {
            throw new BadRequestException(productValidation.getMessage());
        }

        var product = productAdapter.convert(productDTO);
        var productSaved = productRepository.save(product);
        productDTO.setId(productSaved.getId());

        publisher.publish(product);

        return productDTO;
    }

    @Override
    @CacheEvict(cacheNames = "productId", key = "#productDTO.id")
    public ProductDTO updateProduct(ProductDTO productDTO) {
        var productCheck =  productRepository.findById(productDTO.getId()).orElseThrow(ProductNotFoundException::new);

        BeanUtils.copyProperties(productDTO, productCheck);
        productCheck.setCategory(ProductCategory.valueOf(productDTO.getCategory().description()));

        return productAdapter.convert(productRepository.save(productCheck));
    }

    @Override
    public void deleteProduct(Long id) {
        var productCheck =  productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());

        productRepository.deleteById(productCheck.getId());
    }
}
