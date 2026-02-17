package com.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AuthController {
    
    @Autowired
    public UserRepository userRepository;

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
    public String login(@RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {

        Optional<User> userOptional = userRepository.findByEmail(email);
        
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

        redirectAttributes.addFlashAttribute("sucess", "Login efetuado com sucesso!");

        return "redirect:/";
    }
    

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

}
