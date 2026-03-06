package com.ecommerce.controller;

import com.ecommerce.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        if (session.getAttribute("currentUser") == null) {
            System.out.println("User not logged in. Redirecting to SignIn.");
            return "redirect:/signin";
        }

        User currentUser = (User) session.getAttribute("currentUser");

        model.addAttribute("adminSection","dashboard");
        model.addAttribute("currentUser", currentUser);
        return "admin";
    }

}
