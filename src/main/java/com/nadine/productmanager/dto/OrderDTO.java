package com.nadine.productmanager.dto;

import com.nadine.productmanager.enums.OrderStatus;
import lombok.Data;

@Data
public class OrderDTO {

    private Long id;
    private Long clientId;
    private String date;
    private OrderStatus status;

}
