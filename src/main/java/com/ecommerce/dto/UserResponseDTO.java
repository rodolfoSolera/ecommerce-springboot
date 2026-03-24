package com.ecommerce.dto;

import com.ecommerce.model.User;

public record UserResponseDTO(
        Long id,
        String email,
        String fullName,
        User.UserStatus status

) {
    public static UserResponseDTO fromUsers(User user) {
        String fullName = user.getFirstName() + " " + user.getLastName();
        return new UserResponseDTO(
                user.getId(),
                user.getEmail(),
                fullName,
                user.getStatus()
        );
    }
}
