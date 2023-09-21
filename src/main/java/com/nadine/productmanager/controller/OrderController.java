package com.nadine.productmanager.controller;

import com.nadine.productmanager.model.Order;
import com.nadine.productmanager.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder(@PathVariable Long id){
        return orderService.getOrder(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PatchMapping("{id}/cancel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
    }


















































}
