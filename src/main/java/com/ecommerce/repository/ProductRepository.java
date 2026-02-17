package com.ecommerce.repository;

import com.ecommerce.Category;
import com.ecommerce.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Iterable<Product> findByCategory(Category category);
}
