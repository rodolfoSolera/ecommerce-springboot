package com.ecommerce.service;

import com.ecommerce.dto.OrderCreateRequestDTO;
import com.ecommerce.dto.OrderItemRequestDTO;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

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

    public Order createOrderFromApi(OrderCreateRequestDTO request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + request.userId()));

        Order order = new Order(user);

        double totalValue = 0.0;
        int totalItems = 0;

        for (OrderItemRequestDTO itemRequest : request.items()) {
            Product product = productRepository.findById(itemRequest.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + itemRequest.productId()));

            double unitPrice = product.getPrice();
            double subTotal = unitPrice * itemRequest.quantity();

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.quantity());
            orderItem.setUnitPrice(unitPrice);
            orderItem.setSubTotal(subTotal);

            order.addItem(orderItem);

            totalValue += subTotal;
            totalItems += itemRequest.quantity();
        }

        order.setTotalValue(totalValue);
        order.setTotalItems(totalItems);

        return orderRepository.save(order);
    }
}
