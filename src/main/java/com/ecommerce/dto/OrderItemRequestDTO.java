package com.ecommerce.dto;

public record OrderItemRequestDTO(
        Long productId,
        Integer quantity
) {
}
