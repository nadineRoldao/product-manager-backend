package com.nadine.productmanager.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration //indica que a classe deve ser executada quando o componente for inicializado
@EnableCaching
@EnableFeignClients({"com.nadine.productmanager.client"}) // acessando pacote que tem a ProductManagerValidatorClient (api que estou consumindo)
public class AppConfig {
}
