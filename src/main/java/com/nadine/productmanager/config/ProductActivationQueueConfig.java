package com.nadine.productmanager.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductActivationQueueConfig {

    // configuração da fila, para criar e consumir filas

    public static final String KEY = "productActivationKey";
    public static final String QUEUE = "productActivationQueue";
    public static final String EXCHANGE = "productActivationExchange";

    @Bean
    public Queue productActivationQueue() {
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange productActivationExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding productActivationBinding() {
        return BindingBuilder.bind(productActivationQueue()).to(productActivationExchange()).with(KEY);
    }


}
