package com.nadine.productmanager.service.impl;

import com.nadine.productmanager.enums.OrderStatus;
import com.nadine.productmanager.exceptions.BadRequestException;
import com.nadine.productmanager.exceptions.OrderNotFoundException;
import com.nadine.productmanager.model.Order;
import com.nadine.productmanager.repository.OrderRepository;
import com.nadine.productmanager.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException());
    }

    @Override
    public List<Order> getOrders() {
        return  orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order order) {
        if (Objects.isNull(order) || Objects.isNull(order.getClientId())) {
            throw new BadRequestException("O id do cliente precisa ser informado");
        }

        order.setDate(LocalDateTime.now());
        order.setStatus(OrderStatus.CREATED);

        return orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Long id) {
        // recuperar pedido
        var order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException());

        // validar se pode cancelar
        if (OrderStatus.CANCELLED.equals(order.getStatus()) || OrderStatus.FINISHED.equals(order.getStatus())) {
            throw new BadRequestException("Você não pode cancelar um pedido que está finalizado ou que já está cancelado");
        }

        // alterar status
        order.setStatus(OrderStatus.CANCELLED);

        // salvar no banco
        orderRepository.save(order);
    }

    @Override
    public void finishOrder(Long id) {
        var order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException());

        if (OrderStatus.CANCELLED.equals(order.getStatus()) || OrderStatus.FINISHED.equals(order.getStatus())) {
            throw new BadRequestException("Você não pode finalizar um pedido que já está finalizado ou que está cancelado");
        }

        order.setStatus(OrderStatus.FINISHED);

        orderRepository.save(order);
    }
}
