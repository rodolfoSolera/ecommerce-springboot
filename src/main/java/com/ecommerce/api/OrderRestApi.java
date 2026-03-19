package com.ecommerce.api;

import com.ecommerce.dto.TotalSalesDTO;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderRestApi {

    @Autowired
    private OrderService orderService;

    @GetMapping("/total-sales")
    public TotalSalesDTO totalSalesDTO () {
        return TotalSalesDTO.fromTotalSales(orderService.totalSales());
    }
}
