package com.ecommerce.dto;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;

public record ProductResponseDTO(
        Long id,
        String name,
        Category category,
        Double price,
        String state,
        String description
) {
    public static ProductResponseDTO fromProduct(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getStatus().name(),
                product.getDescription()
        );
    }
}
