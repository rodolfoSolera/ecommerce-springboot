package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class DashboardController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            System.out.println("User not logged in. Redirecting to Signin.");
            return "redirect:/signin";
        } else {
            System.out.println("User is logged in as: " + session.getAttribute("currentUser"));
            model.addAttribute("currentUser", session.getAttribute("currentUser"));
        }

        long totalProducts = productRepository.count();
        long totalUsers = userRepository.count();
        long totalOrders = orderRepository.count();
        model.addAttribute("totalProducts", totalProducts);
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("totalOrders", totalOrders);

        Iterable<Order> allOrders = orderRepository.findAll();

        double totalSales = calculateTotalSales(allOrders);
        model.addAttribute("totalSales", totalSales);

        List<Order> recentOrders = getRecentOrders(allOrders, 5);
        model.addAttribute("recentOrders", recentOrders);

        List<Map.Entry<Product, Integer>> topProducts = getTopProducts(allOrders, 5);
        model.addAttribute("topProducts", topProducts);

        model.addAttribute("adminSection", "dashboard");

        User currentUser = (User) session.getAttribute("currentUser");
        model.addAttribute("currentUser", currentUser);

        return "admin";
    }

    private double totalSales() {
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

    private List<Order> getRecentOrders(Iterable<Order> orders, int limit) {
        List<Order> orderList = new ArrayList<>();
        for (Order order : orders) {
            orderList.add(order);
        }

        orderList.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.getCreatedAt().compareTo(o1.getCreatedAt());
            }
        });

        if (orderList.size() > limit) {
            return orderList.subList(0, limit);
        }
        return orderList;
    }

    private List<Map.Entry<Product, Integer>> getTopProducts(Iterable<Order> orders, int limit) {

        Map<Product, Integer> productSalesCount = new HashMap<>();

        for (Order order : orders) {
            for (OrderItem item : order.getItems()) {
                Product product = item.getProduct();
                int quantity = item.getQuantity();

                if (productSalesCount.containsKey(product)) {
                    int currentCount = productSalesCount.get(product);
                } else {
                    productSalesCount.put(product, quantity);
                }
            }
        }

        List<Map.Entry<Product, Integer>> productList = new ArrayList<>(productSalesCount.entrySet());

        productList.sort(new Comparator<Map.Entry<Product, Integer>>() {
            @Override
            public int compare(Map.Entry<Product, Integer> e1, Map.Entry<Product, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        if (productList.size() > limit) {
            return productList.subList(0, limit);
        }
        return productList;
    }
}
