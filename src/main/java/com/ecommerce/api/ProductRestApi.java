package com.ecommerce.api;

import com.ecommerce.dto.ProductResponseDTO;
import com.ecommerce.dto.ProductUpdatePriceRequestDTO;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/products")
public class ProductRestApi {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        Iterable<Product> products = productService.findAllProducts(null);
        return StreamSupport.stream(products.spliterator(), false)
                .map(ProductResponseDTO::fromProduct)
                .toList();
    }

    @PutMapping("/{id}/price")
    public ProductResponseDTO productUpdatePrice(@PathVariable Long id, @RequestBody ProductUpdatePriceRequestDTO request) {
        Product product = productService.productUpdatePrice(id, request.price());
        return ProductResponseDTO.fromProduct(product);
    }
}
