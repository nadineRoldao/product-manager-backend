package com.nadine.productmanager.dto;

import lombok.Data;

// criando uma classe igual ao objeto que tem na api que estou consumindo
@Data
public class ValidationProductDTO {
    private Boolean isValid;
    private String message;
}
