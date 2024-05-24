package com.shopyebee.orderservice.repo;

import com.shopyebee.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
