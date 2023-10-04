package com.nadine.productmanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class AddressDTO {

    private String cep;
    private String logradouro;
    private String bairro;
    private String UF;

    // quando não pode exibir para o usuário
    @JsonIgnore
    private String ibge;

}
