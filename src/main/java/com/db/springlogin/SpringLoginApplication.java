package com.db.springlogin;

import com.db.springlogin.model.Invoice;
import com.db.springlogin.model.Product;
import com.db.springlogin.model.User;
import com.db.springlogin.repository.ProductRepository;
import com.db.springlogin.repository.UserRepository;
import org.assertj.core.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLoginApplication.class, args);
	}

	@Bean
	public CommandLineRunner createAdmin(UserRepository userRepository, ProductRepository productRepository) {
		return args -> {
			final User admin = User.builder()
					.active(true)
					.id(1L)
					.age(50L)
					.password("pass")
					.userName("admin")
					.roles("ROLE_ADMIN")
					.build();
			final User user = User.builder()
					.active(true)
					.id(2L)
					.age(20L)
					.password("pass")
					.userName("user")
					.roles("ROLE_USER")
					.build();
			final Product product1 = Product
					.builder()
					.value(7L)
					.name("Shampoo")
					.build();
			final Product product2 = Product
					.builder()
					.value(2L)
					.name("Cheese")
					.build();
			final Product product3 = Product
					.builder()
					.value(3L)
					.name("Mushrooms")
					.build();
			final Product product4 = Product
					.builder()
					.value(1L)
					.name("Can of red beans")
					.build();
			final Product product5 = Product
					.builder()
					.value(1L)
					.name("Tuna can")
					.build();
			final Product product6 = Product
					.builder()
					.value(2L)
					.name("Eggs")
					.build();
			final Product product7 = Product
					.builder()
					.value(1L)
					.name("Sugar")
					.build();
			final Product product8 = Product
					.builder()
					.value(1L)
					.name("Rice")
					.build();
			final Product product9 = Product
					.builder()
					.value(2L)
					.name("Hot sauce")
					.build();
			final Product product10 = Product
					.builder()
					.value(1L)
					.name("Vinegar")
					.build();
			final Product product11 = Product
					.builder()
					.value(2L)
					.name("Hazelnuts")
					.build();
			final Product product12 = Product
					.builder()
					.value(2L)
					.name("Bacon")
					.build();
			final Product product13 = Product
					.builder()
					.value(1L)
					.name("Pasta")
					.build();
			final Product product14 = Product
					.builder()
					.value(3L)
					.name("Peanut buttter")
					.build();
			final Product product15 = Product
					.builder()
					.value(5L)
					.name("Tea")
					.build();
			final Product product16 = Product
					.builder()
					.value(1L)
					.name("Salsa")
					.build();
			final Product product17 = Product
					.builder()
					.value(3L)
					.name("Onions")
					.build();
			final Product product18 = Product
					.builder()
					.value(2L)
					.name("Mozzarella")
					.build();
			final Product product19 = Product
					.builder()
					.value(2L)
					.name("Oregano")
					.build();
			final Product product20 = Product
					.builder()
					.value(6L)
					.name("Red wine")
					.build();
			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
			productRepository.save(product4);
			productRepository.save(product5);
			productRepository.save(product6);
			productRepository.save(product7);
			productRepository.save(product8);
			productRepository.save(product9);
			productRepository.save(product10);
			productRepository.save(product12);
			productRepository.save(product13);
			productRepository.save(product14);
			productRepository.save(product15);
			productRepository.save(product16);
			productRepository.save(product17);
			productRepository.save(product18);
			productRepository.save(product19);
			productRepository.save(product20);
			userRepository.save(admin);
			userRepository.save(user);
		};
	}

}
