package com.nadine.productmanager.controller;

import com.nadine.productmanager.client.ViaCepConsumerClient;
import com.nadine.productmanager.dto.AddressDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("addresses")
public class AddressController {

    private final ViaCepConsumerClient viaCepConsumerClient;

    @GetMapping("{cep}")
    public AddressDTO getAddress(@PathVariable String cep) {
        var findAddress = viaCepConsumerClient.getAddress(cep);
        return findAddress;
    }
}
