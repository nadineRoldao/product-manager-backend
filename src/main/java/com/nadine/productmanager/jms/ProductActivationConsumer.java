package com.nadine.productmanager.jms;

import com.nadine.productmanager.model.Product;
import com.nadine.productmanager.service.ActivationService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductActivationConsumer {

    private final ActivationService activationService;

    @RabbitListener(queues = "productActivationQueue")
    public void readProductActivationMessage(Product product) {
        activationService.activateProduct(product);
    }

}
