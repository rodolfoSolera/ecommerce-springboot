package com.ecommerce.initializer;

import com.ecommerce.entity.*;
import com.ecommerce.entity.User.UserStatus;

import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
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

    @Autowired
    private OrderRepository orderRepository;


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

        User jozias = createUser("Jozias", "da Silva", "jozias@gmail.com", "(47)99974-9304", "Jozias123@", true);
        User maria = createUser("Maria", "Oliveira", "maria.oliveira@gmail.com", "(11)98845-1234", "Maria@123", true);
        User carlos = createUser("Carlos", "Pereira", "carlos.pereira@gmail.com", "(21)97766-4321", "Carlos#2024", true);
        User ana = createUser("Ana", "Souza", "ana.souza@gmail.com", "(31)99654-7890", "Ana@Senha1", true);
        User fernando = createUser("Fernando", "Lima", "fernando.lima@gmail.com", "(41)98712-3456", "Fer@12345", true);
        User juliana = createUser("Juliana", "Mendes", "juliana.mendes@gmail.com", "(51)99543-2109", "JuMendes@9", true);
        User admin = createUser("Admin", "System", "admin@admin.com", "(11)99635-2197", "Admin@1234", true);

        userRepository.saveAll(Arrays.asList(jozias, maria, carlos, ana, fernando, juliana, admin));

        Iterable<Product> allProducts = productRepository.findAll();
        Product[] products = new Product[70];
        int index = 0;
        for (Product p : allProducts) {
            products[index++] = p;
        }

        // Jozias Pedidos
        orderRepository.save(createOrder(jozias, 4599.00, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(25), products[1]));

        orderRepository.save(createOrder(jozias, 2499.80, 2, Order.OrderStatus.PAID, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(20), products[0], products[9]));

        orderRepository.save(createOrder(jozias, 799.80, 2, Order.OrderStatus.SHIPPED, Order.PaymentMethod.DEBIT_CARD,
                LocalDateTime.now().minusDays(15), products[4], products[5]));

        orderRepository.save(createOrder(jozias, 899.90, 1, Order.OrderStatus.CONFIRMED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(10), products[7]));

        orderRepository.save(createOrder(jozias, 349.80, 2, Order.OrderStatus.DELIVERED, Order.PaymentMethod.BANK_TICKET,
                LocalDateTime.now().minusDays(5), products[8], products[9]));

        orderRepository.save(createOrder(jozias, 199.90, 1, Order.OrderStatus.PAID, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(2), products[23]));

        //Maria Pedidos
        orderRepository.save(createOrder(maria, 149.90, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(28), products[11]));

        orderRepository.save(createOrder(maria, 379.80, 2, Order.OrderStatus.PAID, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(24), products[12], products[16]));

        orderRepository.save(createOrder(maria, 229.90, 1, Order.OrderStatus.SHIPPED, Order.PaymentMethod.DEBIT_CARD,
                LocalDateTime.now().minusDays(18), products[13]));

        orderRepository.save(createOrder(maria, 199.90, 1, Order.OrderStatus.CONFIRMED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(15), products[14]));

        orderRepository.save(createOrder(maria, 239.80, 2, Order.OrderStatus.DELIVERED, Order.PaymentMethod.BANK_TICKET,
                LocalDateTime.now().minusDays(12), products[15], products[17]));

        orderRepository.save(createOrder(maria, 99.90, 1, Order.OrderStatus.PAID, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(9), products[18]));

        orderRepository.save(createOrder(maria, 259.80, 2, Order.OrderStatus.SHIPPED, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(6), products[19], products[10]));

        orderRepository.save(createOrder(maria, 189.90, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.DEBIT_CARD,
                LocalDateTime.now().minusDays(3), products[13]));

        //Carlos Pedidos
        orderRepository.save(createOrder(carlos, 1999.00, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(40), products[34]));

        orderRepository.save(createOrder(carlos, 488.80, 2, Order.OrderStatus.SHIPPED, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(36), products[30], products[31]));

        orderRepository.save(createOrder(carlos, 89.90, 1, Order.OrderStatus.CONFIRMED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(32), products[35]));

        orderRepository.save(createOrder(carlos, 239.80, 2, Order.OrderStatus.DELIVERED, Order.PaymentMethod.DEBIT_CARD,
                LocalDateTime.now().minusDays(28), products[36], products[32]));

        orderRepository.save(createOrder(carlos, 159.90, 1, Order.OrderStatus.PAID, Order.PaymentMethod.BANK_TICKET,
                LocalDateTime.now().minusDays(24), products[36]));

        orderRepository.save(createOrder(carlos, 179.90, 1, Order.OrderStatus.SHIPPED, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(20), products[37]));

        orderRepository.save(createOrder(carlos, 299.90, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(18), products[38]));

        orderRepository.save(createOrder(carlos, 129.90, 1, Order.OrderStatus.PAID, Order.PaymentMethod.DEBIT_CARD,
                LocalDateTime.now().minusDays(15), products[39]));

        orderRepository.save(createOrder(carlos, 229.90, 1, Order.OrderStatus.CONFIRMED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(12), products[12]));

        orderRepository.save(createOrder(carlos, 349.90, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(9), products[25]));

        orderRepository.save(createOrder(carlos, 599.90, 1, Order.OrderStatus.SHIPPED, Order.PaymentMethod.BANK_TICKET,
                LocalDateTime.now().minusDays(6), products[26]));

        orderRepository.save(createOrder(carlos, 199.90, 1, Order.OrderStatus.PAID, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(2), products[27]));

        //Ana Pedidos
        orderRepository.save(createOrder(ana, 2499.00, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(50), products[20]));

        orderRepository.save(createOrder(ana, 2298.00, 2, Order.OrderStatus.SHIPPED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(45), products[21], products[22]));

        orderRepository.save(createOrder(ana, 599.90, 1, Order.OrderStatus.PAID, Order.PaymentMethod.DEBIT_CARD,
                LocalDateTime.now().minusDays(40), products[25]));

        orderRepository.save(createOrder(ana, 5298.00, 2, Order.OrderStatus.CONFIRMED, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(38), products[1], products[3]));

        orderRepository.save(createOrder(ana, 299.90, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(35), products[33]));

        orderRepository.save(createOrder(ana, 699.80, 2, Order.OrderStatus.SHIPPED, Order.PaymentMethod.BANK_TICKET,
                LocalDateTime.now().minusDays(30), products[4], products[5]));

        orderRepository.save(createOrder(ana, 1999.00, 1, Order.OrderStatus.PAID, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(28), products[34]));

        orderRepository.save(createOrder(ana, 4599.00, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(25), products[1]));

        orderRepository.save(createOrder(ana, 398.80, 2, Order.OrderStatus.SHIPPED, Order.PaymentMethod.DEBIT_CARD,
                LocalDateTime.now().minusDays(22), products[42], products[44]));

        orderRepository.save(createOrder(ana, 249.90, 1, Order.OrderStatus.CONFIRMED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(20), products[8]));

        orderRepository.save(createOrder(ana, 1799.00, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(18), products[6]));

        orderRepository.save(createOrder(ana, 329.80, 2, Order.OrderStatus.PAID, Order.PaymentMethod.BANK_TICKET,
                LocalDateTime.now().minusDays(15), products[10], products[18]));

        orderRepository.save(createOrder(ana, 299.90, 1, Order.OrderStatus.SHIPPED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(12), products[39]));

        orderRepository.save(createOrder(ana, 149.90, 1, Order.OrderStatus.CONFIRMED, Order.PaymentMethod.DEBIT_CARD,
                LocalDateTime.now().minusDays(9), products[32]));

        orderRepository.save(createOrder(ana, 499.90, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(5), products[52]));

        //Fernando Pedidos
        orderRepository.save(createOrder(fernando, 899.90, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(30), products[7]));

        orderRepository.save(createOrder(fernando, 299.90, 1, Order.OrderStatus.PAID, Order.PaymentMethod.DEBIT_CARD,
                LocalDateTime.now().minusDays(26), products[38]));

        orderRepository.save(createOrder(fernando, 1599.80, 2, Order.OrderStatus.SHIPPED, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(22), products[20], products[8]));

        orderRepository.save(createOrder(fernando, 129.90, 1, Order.OrderStatus.CONFIRMED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(18), products[56]));

        orderRepository.save(createOrder(fernando, 449.80, 2, Order.OrderStatus.DELIVERED, Order.PaymentMethod.BANK_TICKET,
                LocalDateTime.now().minusDays(15), products[41], products[43]));

        orderRepository.save(createOrder(fernando, 399.90, 1, Order.OrderStatus.SHIPPED, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(10), products[37]));

        orderRepository.save(createOrder(fernando, 99.90, 1, Order.OrderStatus.PAID, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(3), products[47]));

        //Juliana Pedidos
        orderRepository.save(createOrder(juliana, 199.90, 1, Order.OrderStatus.DELIVERED, Order.PaymentMethod.PIX,
                LocalDateTime.now().minusDays(8), products[50]));

        orderRepository.save(createOrder(juliana, 349.80, 2, Order.OrderStatus.PAID, Order.PaymentMethod.CREDIT_CARD,
                LocalDateTime.now().minusDays(2), products[51], products[52]));

    }

    private Order createOrder(
            User user,
            Double totalValue,
            Integer totalItems,
            Order.OrderStatus status,
            Order.PaymentMethod paymentMethod,
            LocalDateTime createdAt,
            Product... products
    ) {

        Order order = new Order();

        order.setUser(user);
        order.setTotalValue(totalValue);
        order.setTotalItems(totalItems);
        order.setStatus(status);
        order.setPaymentMethod(paymentMethod);
        order.setCreatedAt(createdAt);

        for (Product product : products) {

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(1);
            item.setUnitPrice(product.getPrice());

            order.addItem(item);
        }

        return order;
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
