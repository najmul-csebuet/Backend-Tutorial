package com.onssoftware.mongodbConnectionTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongodbConnectionTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbConnectionTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner dbTest(AccountRepository accRepo) {
		return args -> {
			Account acc = new Account();
			acc.setName("Md Najmul Hasan");
			accRepo.save(acc);
		};
	}
}