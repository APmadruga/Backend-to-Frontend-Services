package com.db.springlogin;

import com.db.springlogin.model.Invoice;
import com.db.springlogin.model.User;
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
	public CommandLineRunner createAdmin(UserRepository userRepository) {
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
			userRepository.save(admin);
			userRepository.save(user);
		};
	}

}
