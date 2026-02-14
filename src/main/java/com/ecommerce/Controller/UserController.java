package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.User;
import com.ecommerce.Repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("adminSection","user");

        model.addAttribute("user", new User());

        Iterable<User> users;

        users = userRepository.findAll();

        model.addAttribute("users", users);
        return "admin";
    }
}
