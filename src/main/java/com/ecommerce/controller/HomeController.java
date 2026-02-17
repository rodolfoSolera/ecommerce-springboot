package com.ecommerce.controller;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) Category category) {
        model.addAttribute("title","Super loja ONLINE!");
        model.addAttribute("categories", Category.values());
        model.addAttribute("categoriesFilter", category !=null ? category : "ALL" );

        Iterable<Product> products;

        if (category != null) {
            products = productRepository.findByCategory(category);
        } else {
            products = productRepository.findAll();
        }

        model.addAttribute("products", products);

        return "index";
    }
}
