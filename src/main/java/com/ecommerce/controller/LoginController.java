package com.ecommerce.controller;

import java.util.Optional;

import com.ecommerce.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.model.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
    
    @Autowired
    public UserService userService;

    @GetMapping("/signin")
    public String signIn() {
        return "signin";
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            RedirectAttributes redirectAttributes,
            HttpSession session
    ) {

        System.out.println("Attempting signin for email: " + email);

        Optional<User> userOptional = userService.findByEmail(email);
        
        if (userOptional.isEmpty()) {
            System.out.println("E-mail not found");
            redirectAttributes.addFlashAttribute("error", "E-mail nao cadastrado!");
            return "redirect:/signin";
        }

        User user = userOptional.get();

        if (!user.getPassword().equals(password)) {
            System.out.println("Invalid Password");
            redirectAttributes.addFlashAttribute("error", "Senha invalida!");
            return "redirect:/signin";
        }

        System.out.println("User logged in successsfully: " + user);
        redirectAttributes.addFlashAttribute("message", "Login realizado com sucesso!");

        session.setAttribute("currentUser", user);

        return "redirect:/";
    }
    

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        System.out.println("User logged out");
        session.invalidate();

        return "redirect:/";
    }

}
