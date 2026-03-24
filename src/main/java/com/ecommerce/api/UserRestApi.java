package com.ecommerce.api;

import com.ecommerce.dto.UserResponseDTO;
import com.ecommerce.dto.UserUpdateStatusRequestDTO;
import com.ecommerce.model.User;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/users")
public class UserRestApi {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        Iterable<User> users = userService.findAllUsers(null);
        return StreamSupport.stream(users.spliterator(), false)
                .map(UserResponseDTO::fromUsers)
                .toList();
    }

    @PutMapping("/{id}/status")
    public UserResponseDTO userUpdateStatus(@PathVariable Long id, @RequestBody UserUpdateStatusRequestDTO request) {
        User user = userService.updateStatus(id,request.status());
        return UserResponseDTO.fromUsers(user);
    }
}
