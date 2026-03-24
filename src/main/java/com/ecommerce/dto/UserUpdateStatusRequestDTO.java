package com.ecommerce.dto;

import com.ecommerce.model.User;

public record UserUpdateStatusRequestDTO(
        User.UserStatus status
) {
}
