package com.nadine.productmanager.client;

import com.nadine.productmanager.dto.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCepConsumer", url = "viacep.com.br")
public interface ViaCepConsumerClient {

    @GetMapping("ws/{cep}/json/")
    AddressDTO getAddress(@PathVariable(value = "cep") String cep);

}
