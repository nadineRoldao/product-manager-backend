package com.nadine.productmanager.client;

import com.nadine.productmanager.dto.ProductDTO;
import com.nadine.productmanager.dto.ValidationProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// recuperando API que estou consumindo
@FeignClient(name = "productManagerValidator", url = "http://localhost:3030")
public interface ProductManagerValidatorClient {

    // recuperando verbo http da api que eu quero consumir
    // o java nao chama o metodo do node, ele chama a url no node e pega o texto que ele exibe, da mesma forma de quando voce coloca na url
    @PostMapping("products/validate")
    // se na api eu passo um body, eu recupero ele aqui
    ValidationProductDTO validateProduct(@RequestBody ProductDTO productDTO);

}
