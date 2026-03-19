package com.ecommerce.api;

import com.ecommerce.dto.UserDTO;
import com.ecommerce.model.User;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/users")
public class UserRestApi {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        Iterable<User> users = userService.findAllUsers(null);
        return StreamSupport.stream(users.spliterator(), false)
                .map(UserDTO::fromUsers)
                .toList();
    }
}
