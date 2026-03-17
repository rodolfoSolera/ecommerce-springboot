package com.ecommerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/user")
    public String user(Model model, @RequestParam(required = false) User.UserStatus status, HttpSession session) {

        if (session.getAttribute("currentUser") == null) {
            System.out.println("User not logged in. Redirecting to SignIn.");
            return "redirect:/signin";
        }

        User currentUser = (User) session.getAttribute("currentUser");

        if (model.containsAttribute("adminSection")) {
            model.addAttribute("adminSection", model.getAttribute("adminSection"));
        } else {
            model.addAttribute("adminSection","user");
        }

        if (model.containsAttribute("user")) {
            model.addAttribute("user", model.getAttribute("user"));
        } else {
            model.addAttribute("user", new User());
        }

        Iterable<User> users;

        if (status != null) {
            users = userRepository.findByStatus(status);
        } else {
            users = userRepository.findAll();
        }

        model.addAttribute("statusFilter", status != null ? status : "ALL");
        model.addAttribute("status", User.UserStatus.values());
        model.addAttribute("users", users);
        model.addAttribute("currentUser", currentUser);
        return "admin";
    }

    @PostMapping("/signup")
    public String saveUser(@ModelAttribute User user) {
        System.out.println("Saving user " + user);
        userRepository.save(user.active());
        return "redirect:/user";
    }

    @PostMapping("/user/save")
    public String saveUsers(@ModelAttribute User user) {
        System.out.println("Saving user " + user);
        userRepository.save(user);
        return "redirect:/user";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            System.out.println("User found ID: " + id);
            redirectAttributes.addFlashAttribute("user", user.get());
        } else {
            System.out.println("User not found ID: " + id);
        }

        return "redirect:/user";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        System.out.println("Deleting user with ID: " + id);

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            System.out.println("User ID: " + id + "deleted");
            redirectAttributes.addFlashAttribute("user", user.get());
            redirectAttributes.addFlashAttribute("adminSection", "userDelete");
        } else {
            System.out.println("User not foud ID: " + id);
        }

        return "redirect:/user";
    }

    @GetMapping("/user/delete/confirmation/{id}")
    public String confirmationDelete(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/user";
    }
}
