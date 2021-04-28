package com.example.ConsumerListObjFromJson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class ConsumerListObjFromJsonApplication {

    private String BASE_URL = "http://localhost:8081/api/users";
    private RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(ConsumerListObjFromJsonApplication.class, args);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {
            try {
                ResponseEntity<List<MyUser>> exchange = restTemplate.exchange(
                        BASE_URL,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<MyUser>>() {
                        }
                );
                List<MyUser> body = exchange.getBody();
                System.out.println(body);
            } catch (Exception e) {
                System.out.println(e);
            }
        };
    }
}
