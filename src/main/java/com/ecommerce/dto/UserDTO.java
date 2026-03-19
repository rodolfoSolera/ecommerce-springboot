package com.ecommerce.dto;

import com.ecommerce.model.User;

public record UserDTO(
        Long id,
        String email,
        String fullName
) {
    public static UserDTO fromUsers(User user) {
        String fullName = user.getFirstName() + " " + user.getLastName();
        return new UserDTO(
                user.getId(),
                user.getEmail(),
                fullName
        );
    }
}
