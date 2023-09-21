package com.nadine.productmanager.controller;

import com.nadine.productmanager.model.Product;
import com.nadine.productmanager.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@PathVariable Long id,
                              @RequestParam(value = "name") String name,
                              @RequestParam(value = "category") String category,
                              @RequestParam(value = "price") Double price,
                              @RequestParam(value = "link", required = false) String link) {

        return productService.updateProduct(id, name, category, price, link);

    }

}

