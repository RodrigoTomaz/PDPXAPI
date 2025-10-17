package com.br.pedeplux.config;

import com.br.pedeplux.enums.OrderStatus;
import com.br.pedeplux.models.Category;
import com.br.pedeplux.models.Order;
import com.br.pedeplux.models.Product;
import com.br.pedeplux.models.User;
import com.br.pedeplux.repositories.CategoryRepository;
import com.br.pedeplux.repositories.OrderRepository;
import com.br.pedeplux.repositories.ProductRepository;
import com.br.pedeplux.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class RunTestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Rodrigo", "rodpay", "123", "31971864280");
        User user2 = new User("Ana Paula", "anap", "senha123", "11987654321");
        User user3 = new User("Carlos Silva", "carloss", "abc123", "21999887766");
        User user4 = new User("Mariana Costa", "mari.c", "pass456", "31995544332");
        User user5 = new User("João Pedro", "jp1990", "jp1234", "11971234567");
        User user6 = new User("Larissa Lima", "lari.l", "senha789", "31987654320");
        User user7 = new User("Felipe Gomes", "fegomes", "senha321", "21991234567");
        User user8 = new User("Juliana Rocha", "ju_rocha", "jul123", "11999988777");
        User user9 = new User("Ricardo Alves", "ricardo.a", "ric789", "31991112233");
        User user10 = new User("Beatriz Mendes", "bia.m", "bia456", "21990001122");

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10));

        Order order1 = new Order(null, Instant.now(), user1, OrderStatus.PAID);
        Order order2 = new Order(null, Instant.now(), user5, OrderStatus.WAITING_PAYMENT);
        Order order3 = new Order(null, Instant.now(), user1, OrderStatus.DELIVERED);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        Category category1 = new Category(null, "Eletrônicos");
        Category category2 = new Category(null, "Moda");
        Category category3 = new Category(null, "Casa e Móveis");
        Category category4 = new Category(null, "Esportes e Lazer");
        Category category5 = new Category(null, "Beleza e Cuidados Pessoais");
        Category category6 = new Category(null, "Livros");
        Category category7 = new Category(null, "Brinquedos");
        Category category8 = new Category(null, "Alimentos e Bebidas");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3, category4, category5, category6, category7, category8));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    }
}
