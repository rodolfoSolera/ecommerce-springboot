package com.ecommerce.controller;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

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

        if (session.getAttribute("shoppingCartView") != null) {
            model.addAttribute("shoppingCartView", session.getAttribute("shoppingCartView"));
            model.addAttribute("cartTotalItems", session.getAttribute("cartTotalItems"));
            model.addAttribute("cartTotalValue", session.getAttribute("cartTotalValue"));
        }

        Iterable<Product> products = productService.findAllProducts(category);

        model.addAttribute("products", products);
        model.addAttribute("currentUser", currentUser);

        return "index";
    }
}
