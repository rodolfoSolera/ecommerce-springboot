package com.ecommerce.repository;

import com.ecommerce.Category;
import com.ecommerce.Product;
import com.ecommerce.User;
import com.ecommerce.User.UserStatus;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String @NonNull ... args) {

        System.out.println("DataInitializer run method executed");

        productRepository.saveAll(Arrays.asList(
                
                // =========================
                // ELETRÔNICOS
                // =========================
                createdProduct("Smartphone Android", Category.ELETRONICS, 1999.90, "Smartphone com 128GB"),
                createdProduct("Notebook Ultrafino", Category.ELETRONICS, 4599.00, "Notebook leve"),
                createdProduct("Fone Bluetooth", Category.ELETRONICS, 299.90, "Cancelamento de ruído"),
                createdProduct("Smart TV 50\"", Category.ELETRONICS, 2899.00, "TV 4K"),
                createdProduct("Mouse Gamer", Category.ELETRONICS, 149.90, "Alta precisão"),
                createdProduct("Teclado Mecânico", Category.ELETRONICS, 399.90, "Switch blue"),
                createdProduct("Tablet 10\"", Category.ELETRONICS, 1799.00, "Ideal para estudos"),
                createdProduct("Smartwatch", Category.ELETRONICS, 899.90, "Monitor cardíaco"),
                createdProduct("Caixa de Som", Category.ELETRONICS, 249.90, "Som portátil"),
                createdProduct("Power Bank", Category.ELETRONICS, 129.90, "20000mAh"),

                // =========================
                // ROUPAS
                // =========================
                createdProduct("Camiseta Básica", Category.CLOTHING, 59.90, "100% algodão"),
                createdProduct("Calça Jeans", Category.CLOTHING, 149.90, "Jeans azul"),
                createdProduct("Jaqueta Jeans", Category.CLOTHING, 229.90, "Estilosa"),
                createdProduct("Moletom", Category.CLOTHING, 189.90, "Confortável"),
                createdProduct("Vestido Casual", Category.CLOTHING, 199.90, "Leve"),
                createdProduct("Camisa Social", Category.CLOTHING, 139.90, "Slim fit"),
                createdProduct("Shorts Esportivo", Category.CLOTHING, 89.90, "Treino"),
                createdProduct("Saia Midi", Category.CLOTHING, 159.90, "Elegante"),
                createdProduct("Blusa Feminina", Category.CLOTHING, 99.90, "Dia a dia"),
                createdProduct("Casaco de Inverno", Category.CLOTHING, 299.90, "Térmico"),

                // =========================
                // CASA & JARDIM
                // =========================
                createdProduct("Sofá 3 Lugares", Category.HOME_GARDEN, 2499.00, "Confortável"),
                createdProduct("Mesa de Jantar", Category.HOME_GARDEN, 1899.00, "6 lugares"),
                createdProduct("Cadeira Decorativa", Category.HOME_GARDEN, 399.90, "Moderna"),
                createdProduct("Luminária", Category.HOME_GARDEN, 199.90, "Mesa"),
                createdProduct("Tapete Sala", Category.HOME_GARDEN, 299.90, "Macio"),
                createdProduct("Estante", Category.HOME_GARDEN, 599.90, "Multiuso"),
                createdProduct("Vaso Decorativo", Category.HOME_GARDEN, 129.90, "Cerâmica"),
                createdProduct("Churrasqueira", Category.HOME_GARDEN, 899.90, "Portátil"),
                createdProduct("Rede de Descanso", Category.HOME_GARDEN, 149.90, "Conforto"),
                createdProduct("Kit Jardinagem", Category.HOME_GARDEN, 99.90, "Ferramentas"),

                // =========================
                // ESPORTES
                // =========================
                createdProduct("Bola de Futebol", Category.SPORTS, 129.90, "Oficial"),
                createdProduct("Tênis de Corrida", Category.SPORTS, 399.90, "Leve"),
                createdProduct("Luvas Academia", Category.SPORTS, 79.90, "Proteção"),
                createdProduct("Corda de Pular", Category.SPORTS, 49.90, "Ajustável"),
                createdProduct("Bicicleta", Category.SPORTS, 1999.00, "Urbana"),
                createdProduct("Colchonete", Category.SPORTS, 89.90, "Fitness"),
                createdProduct("Halter 10kg", Category.SPORTS, 159.90, "Emborrachado"),
                createdProduct("Camisa Esportiva", Category.SPORTS, 99.90, "Dry fit"),
                createdProduct("Raquete de Tênis", Category.SPORTS, 299.90, "Profissional"),
                createdProduct("Garrafa Térmica", Category.SPORTS, 79.90, "Mantém temp."),

                // =========================
                // BRINQUEDOS
                // =========================
                createdProduct("Quebra-cabeça 1000 peças", Category.TOYS, 89.90, "Raciocínio"),
                createdProduct("Boneco de Ação", Category.TOYS, 79.90, "Articulado"),
                createdProduct("Carrinho", Category.TOYS, 49.90, "Infantil"),
                createdProduct("Jogo de Tabuleiro", Category.TOYS, 149.90, "Família"),
                createdProduct("Blocos de Montar", Category.TOYS, 199.90, "Criatividade"),
                createdProduct("Pelúcia", Category.TOYS, 59.90, "Macia"),
                createdProduct("Pista de Corrida", Category.TOYS, 179.90, "Com carrinhos"),
                createdProduct("Jogo Educativo", Category.TOYS, 99.90, "Aprendizado"),
                createdProduct("Boneca", Category.TOYS, 89.90, "Clássica"),
                createdProduct("Drone Infantil", Category.TOYS, 299.90, "Fácil uso"),

                // =========================
                // BELEZA
                // =========================
                createdProduct("Kit Maquiagem", Category.BEAUTY, 199.90, "Completo"),
                createdProduct("Perfume", Category.BEAUTY, 249.90, "Marcante"),
                createdProduct("Secador", Category.BEAUTY, 299.90, "Profissional"),
                createdProduct("Chapinha", Category.BEAUTY, 199.90, "Rápida"),
                createdProduct("Creme Facial", Category.BEAUTY, 79.90, "Hidratação"),
                createdProduct("Kit Skincare", Category.BEAUTY, 149.90, "Diário"),
                createdProduct("Base Líquida", Category.BEAUTY, 89.90, "Uniforme"),
                createdProduct("Máscara Facial", Category.BEAUTY, 39.90, "Relaxante"),
                createdProduct("Pincéis", Category.BEAUTY, 119.90, "12 peças"),
                createdProduct("Esmalte", Category.BEAUTY, 19.90, "Durável"),

                // =========================
                // AUTOMOTIVO
                // =========================
                createdProduct("Aspirador Automotivo", Category.AUTOMOTIVE, 149.90, "Portátil"),
                createdProduct("Capa de Banco", Category.AUTOMOTIVE, 199.90, "Proteção"),
                createdProduct("Suporte Celular", Category.AUTOMOTIVE, 59.90, "Fixação"),
                createdProduct("Carregador Veicular", Category.AUTOMOTIVE, 49.90, "Rápido"),
                createdProduct("Tapete Automotivo", Category.AUTOMOTIVE, 129.90, "Borracha"),
                createdProduct("Kit Limpeza", Category.AUTOMOTIVE, 89.90, "Interna"),
                createdProduct("Câmera de Ré", Category.AUTOMOTIVE, 299.90, "Estacionamento"),
                createdProduct("Alarme", Category.AUTOMOTIVE, 399.90, "Segurança"),
                createdProduct("Calibrador Digital", Category.AUTOMOTIVE, 79.90, "Precisão"),
                createdProduct("Capa Volante", Category.AUTOMOTIVE, 69.90, "Conforto")
                )
        );

        userRepository.saveAll(Arrays.asList(
                
                // =========================
                // Users
                // =========================
                createUser("Jozias", "da Silva", "jozias@gmail.com", "(47)99974-9304", "Jozias123@", true),
                createUser("Maria", "Oliveira", "maria.oliveira@gmail.com", "(11)98845-1234", "Maria@123", true),
                createUser("Carlos", "Pereira", "carlos.pereira@gmail.com", "(21)97766-4321", "Carlos#2024", true),
                createUser("Ana", "Souza", "ana.souza@gmail.com", "(31)99654-7890", "Ana@Senha1", true),
                createUser("Fernando", "Lima", "fernando.lima@gmail.com", "(41)98712-3456", "Fer@12345", true),
                createUser("Juliana", "Mendes", "juliana.mendes@gmail.com", "(51)99543-2109", "JuMendes@9", true)

            )
        );
    }

    private Product createdProduct(String name, Category category, Double price, String description) {
        Product product = new Product();

        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        product.setState("ativo");
        product.setDescription(description);

        return product;
    }

    private User createUser(String firstName, String lastName, String email, String phone, String password, Boolean newsletter) {
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        user.setNewsletter(newsletter);
        user.setStatus(UserStatus.ACTIVE);
        user.setCreatedAt(LocalDateTime.now());
        
        return user;
    }
}
