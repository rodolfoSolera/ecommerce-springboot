package com.ecommerce.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class UserTest {

    private User user;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;

    @BeforeEach
    void setUp() {

        user = new User();
        firstName = "Rodolfo";
        lastName = "Solera";
        password = "0123456RR*";
        email = "rodolfosolera.dev@gmail.com";
        phone = "(47)996352-197";
        boolean newsletter = true;

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setNewsletter(newsletter);

    }

    @Test
    void testUserCreation() {

        Assertions.assertEquals(firstName, user.getFirstName());
        Assertions.assertEquals(lastName, user.getLastName());
        Assertions.assertEquals(password, user.getPassword());
        Assertions.assertEquals(email, user.getEmail());
        Assertions.assertEquals(phone, user.getPhone());
        Assertions.assertTrue(user.getNewsletter(), "Newsletter should be true.");
        Assertions.assertEquals(User.UserStatus.ACTIVE, user.getStatus());
        Assertions.assertEquals(LocalDateTime.now().toLocalDate(), user.getCreatedAt().toLocalDate(), "Created date should be today.");

    }

    @Test
    void testUserStatusChange() {

        Assertions.assertEquals(User.UserStatus.ACTIVE, user.getStatus());

        user.inactive();
        Assertions.assertEquals(User.UserStatus.INACTIVE, user.getStatus());

        user.blocked();
        Assertions.assertEquals(User.UserStatus.BLOCKED, user.getStatus());

        user.suspended();
        Assertions.assertEquals(User.UserStatus.SUSPENDED, user.getStatus());

    }
}
