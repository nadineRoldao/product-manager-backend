package com.nadine.productmanager.model;

import com.nadine.productmanager.enums.OrderStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Order {
    private Long id;
    private Long clientId;
    private String createdAt;
    private OrderStatus status;
}
