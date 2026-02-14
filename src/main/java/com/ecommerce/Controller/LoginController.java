package com.ecommerce.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.User;
import com.ecommerce.Repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
    
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
            redirectAttributes.addFlashAttribute("error", "User/Email not found");
            return "redirect:/";
        }

        User user = userOptional.get();

        if (!user.getPassword().equals(password)) {
            System.out.println("Invalid Password");
            redirectAttributes.addFlashAttribute("error", "Invalid Password!");
            return "redirect:/";
        }

        redirectAttributes.addFlashAttribute("sucess", "User accepted");

        return "redirect:/";
    }
    

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

}
