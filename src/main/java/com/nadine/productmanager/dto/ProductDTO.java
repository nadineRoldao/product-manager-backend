package com.nadine.productmanager.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private Long id;
    private String name;
    private CategoryDTO category;
    private Double price;
    private String link;
}
