package com.ecommerce.api;

import com.ecommerce.dto.OrderCreateRequestDTO;
import com.ecommerce.dto.OrderResponseDTO;
import com.ecommerce.dto.TotalSalesDTO;
import com.ecommerce.model.Order;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderRestApi {

    @Autowired
    private OrderService orderService;

    @GetMapping("/total-sales")
    public TotalSalesDTO totalSalesDTO () {
        return TotalSalesDTO.fromTotalSales(orderService.totalSales());
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderCreateRequestDTO request) {
        Order order = orderService.createOrderFromApi(request);
        OrderResponseDTO response = OrderResponseDTO.fromOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
