package com.ecommerce.controller;

import com.ecommerce.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/user")
    public String user(Model model, @RequestParam(required = false) User.UserStatus status) {
        model.addAttribute("adminSection","user");

        model.addAttribute("user", new User());

        Iterable<User> users;

        if (status != null) {
            users = userRepository.findByStatus(status);
        } else {
            users = userRepository.findAll();
        }

        model.addAttribute("statusFilter", status != null ? status : "ALL");
        model.addAttribute("status", User.UserStatus.values());
        model.addAttribute("users", users);
        return "admin";
    }

    @PostMapping("/signup")
    public String saveUser(@ModelAttribute User user) {
        System.out.println("Saving user " + user);

        userRepository.save(user.active());

        return "redirect:/signin";
    }
}
