package com.nadine.productmanager.jms;

import com.nadine.productmanager.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import static com.nadine.productmanager.config.ProductActivationQueueConfig.EXCHANGE;
import static com.nadine.productmanager.config.ProductActivationQueueConfig.KEY;

@Component
@AllArgsConstructor
public class ProductActivationPublisher {

    private final AmqpTemplate rabbitTemplate;

    public void publish(Product product) {
        rabbitTemplate.convertAndSend(EXCHANGE, KEY, product);
    }

}
