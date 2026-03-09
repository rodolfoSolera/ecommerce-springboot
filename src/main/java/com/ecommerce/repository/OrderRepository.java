package com.ecommerce.repository;

import com.ecommerce.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    Iterable<Order> findAllByUserId(Long userId);
    Iterable<Order> findAllByStatusAndUserId(Order.OrderStatus status, Long userId);
}
