package com.ecommerce.service;

import com.ecommerce.model.Order;
import com.ecommerce.model.User;
import com.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Iterable<Order> findAllByStatus(boolean isAdmin, Order.OrderStatus status, User currentUser) {
        Iterable<Order> orders;

        if (isAdmin) {
            if (status != null) {
                orders = orderRepository.findAllByStatus(status);
            } else {
                orders = orderRepository.findAll();
            }
        } else {
            if (status != null) {
                orders = orderRepository.findAllByStatusAndUserId(status, currentUser.getId());
            } else {
                orders = orderRepository.findAllByUserId(currentUser.getId());
            }
        }
        return orders;
    }

    public Order createdOrUpdate(Order order) {
        return orderRepository.save(order);
    }

    public double totalSales() {
        Iterable<Order> allOrders = orderRepository.findAll();
        return calculateTotalSales(allOrders);
    }

    private double calculateTotalSales(Iterable<Order> orders) {
        double total = 0.0;
        for (Order order : orders) {
            total += order.getTotalValue();
        }
        return total;
    }
}
