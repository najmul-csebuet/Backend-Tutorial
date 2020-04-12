package com.onssoftware.postgresConnectionTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PostgresConnectionTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresConnectionTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner dbTest(AccountRepository accRepo) {
		return args -> {
			Account acc = new Account();
			accRepo.save(acc);
		};
	}
}