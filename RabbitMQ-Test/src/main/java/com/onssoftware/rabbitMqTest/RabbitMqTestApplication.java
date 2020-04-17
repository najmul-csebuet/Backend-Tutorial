package com.onssoftware.rabbitMqTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitMqTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner testSend() {
		return args -> {
			Producer producer = new Producer();
			producer.sendMessage("Bismillah");

			Consumer consumer = new Consumer();
			consumer.consumeMessage();
		};
	}
}
