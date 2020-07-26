package com.onssoftware.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class EmailSendingApplication {

	@Autowired
	private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(EmailSendingApplication.class, args);
	}

	@Bean
	public void sendEmail() {

		SimpleMailMessage msg = new SimpleMailMessage();
		//msg.setTo("to_1@gmail.com", "to_2@gmail.com", "to_3@yahoo.com");
		msg.setTo("najmul@qianalysis.com");
		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		javaMailSender.send(msg);
	}
}
