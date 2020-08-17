package com.onssoftware.querydslJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuerydslJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuerydslJpaApplication.class, args);
	}

	public static int test() {
		Account account = new Account();
		//account
		return 1;
	}
}
