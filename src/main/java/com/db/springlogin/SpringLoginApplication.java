package com.db.springlogin;

import com.db.springlogin.model.User;
import com.db.springlogin.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
					.id(1)
					.password("pass")
					.userName("admin")
					.roles("ROLE_ADMIN")
					.build();
			final User user = User.builder()
					.active(true)
					.id(2)
					.password("pass")
					.userName("user")
					.roles("ROLE_USER")
					.build();
			userRepository.save(admin);
			userRepository.save(user);
		};
	}

}
