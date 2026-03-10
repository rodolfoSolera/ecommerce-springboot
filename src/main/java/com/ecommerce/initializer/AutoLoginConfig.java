package com.ecommerce.initializer;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Optional;

@Component
public class AutoLoginConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private Environment environment;

    @Override
    public void run(String... args) throws Exception {
        // Verificar se o profile 'admin' está ativo
        if (Arrays.asList(environment.getActiveProfiles()).contains("admin")) {
            System.out.println("=".repeat(60));
            System.out.println("AUTO LOGIN ADMIN MODE ENABLED");
            System.out.println("=".repeat(60));

            // Buscar usuário admin
            Optional<User> adminUser = userRepository.findByEmail("admin@admin.com");

            if (adminUser.isPresent()) {
                // Cria uma sessão simulada para o admin
                System.out.println("Admin user found: " + adminUser.get().getEmail());
                System.out.println("Admin will be automatically logged in on first request");
                System.out.println("Navigate to: http://localhost:8080/admin");
                System.out.println("=".repeat(60));

                // Armazena o admin user em um atributo da aplicação para uso posterior
                if (applicationContext instanceof WebApplicationContext) {
                    ((WebApplicationContext) applicationContext).getServletContext()
                            .setAttribute("autoLoginUser", adminUser.get());
                } else {
                    System.out.println("WARNING: Admin user not found!");
                    System.out.println("=".repeat(60));
                }
            }

        }
    }

}
