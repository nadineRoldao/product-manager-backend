package com.nadine.productmanager.service;

import com.nadine.productmanager.model.Order;

import java.util.List;

public interface OrderService {

    Order getOrder(Long id);

    List<Order> getOrders();

    Order createOrder(Order order);

    void cancelOrder(Long id);

    void finishOrder(Long id);
}
