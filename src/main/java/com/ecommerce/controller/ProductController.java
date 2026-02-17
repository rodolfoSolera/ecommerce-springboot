package com.ecommerce.controller;

import com.ecommerce.Category;
import com.ecommerce.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public String product(Model model, @RequestParam(required = false) Category category) {
        if (model.containsAttribute("adminSection")) {
            model.addAttribute("adminSection", model.getAttribute("adminSection"));
        } else {
            model.addAttribute("adminSection","product");
        }

        if (model.containsAttribute("product")) {
            model.addAttribute("product", model.getAttribute("product"));
        } else {
            model.addAttribute("product", new Product());
        }

        Iterable<Product> products;

        if (category != null) {
            products = productRepository.findByCategory(category);
        } else {
            products = productRepository.findAll();
        }

        model.addAttribute("categoriesFilter", category != null ? category : "ALL");
        model.addAttribute("categories", Category.values());
        model.addAttribute("products", products);
        return "admin";
    }

    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute Product product) {
        System.out.println("Saving product " + product);
        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            System.out.println("Product found ID: " + id);
            redirectAttributes.addFlashAttribute("product", product.get());
        } else {
            System.out.println("Product not found ID: " + id);
        }

        return "redirect:/product";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        System.out.println("Deleting product with ID: " + id);

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            System.out.println("Product ID: " + id + "deleted");
            redirectAttributes.addFlashAttribute("product", product.get());
            redirectAttributes.addFlashAttribute("adminSection", "productDelete");
        } else {
            System.out.println("Product not foud ID: " + id);
        }

        return "redirect:/product";
    }

    @GetMapping("/product/delete/confirmation/{id}")
    public String confirmationDelete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/product";
    }
}
