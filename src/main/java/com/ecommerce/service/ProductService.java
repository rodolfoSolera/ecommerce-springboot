package com.ecommerce.service;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAllProducts(Category category) {
        Iterable<Product> products;

        if (category != null) {
            products = productRepository.findByCategoryAndStatus(category, Product.ProductStatus.CREATED);
        } else {
            products = productRepository.findAllByStatus(Product.ProductStatus.CREATED);
        }

        return products;
    }

    public Product createdOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {

        Product product = productRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Product with id: " + id + " not found!"));

        productRepository.save(product.delete());
    }

    public Product productUpdatePrice(Long id, Double price) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setPrice(price);
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product with id: " + id + " not found!");
        }
    }
}
