package com.nadine.productmanager.repository;

import com.nadine.productmanager.model.OrderItem;
import com.nadine.productmanager.model.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
