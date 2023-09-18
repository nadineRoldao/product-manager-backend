package com.nadine.productmanager.controller;

import com.nadine.productmanager.enums.OrderStatus;
import com.nadine.productmanager.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder(@PathVariable Long id){
        return null;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrders() {
        return  new ArrayList<>();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
        order.setId(1L);
        order.setStatus(OrderStatus.CREATED);
        return order;
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelOrder(@PathVariable Long id) {
        System.out.println("O pedido de " + id + " foi cancelado");
    }


















































}
