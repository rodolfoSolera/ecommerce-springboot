package com.ecommerce.controller;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
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
    public String home(Model model, HttpSession session, @RequestParam(required = false) Category category) {
        model.addAttribute("title","Super loja Online!");
        model.addAttribute("categories", Category.values());
        model.addAttribute("categoriesFilter", category !=null ? category : "ALL" );

        User currentUser = (User) session.getAttribute("currentUser");
        model.addAttribute("currentUser", session.getAttribute("currentUser"));

        if (session.getAttribute("currentUser") != null) {
            model.addAttribute("currentUser", session.getAttribute("currentUser"));
        }

        if (session.getAttribute("shoppingCart") != null) {
            model.addAttribute("shoppingCart", session.getAttribute("shoppingCart"));
        }

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
