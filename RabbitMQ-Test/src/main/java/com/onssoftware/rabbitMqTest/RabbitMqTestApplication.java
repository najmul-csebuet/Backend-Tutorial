package com.onssoftware.rabbitMqTest;

import com.onssoftware.rabbitMqTest.helloWorld.basicWay.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RabbitMqTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqTestApplication.class, args);
	}

	//@Bean
	public CommandLineRunner testSend() {
		return args -> {
			Send m = new Send();
			Send send = new Send();
			send.sendMessage("Bismillah");

			Recv recv = new Recv();
			recv.consumeMessage();
		};
	}
}
