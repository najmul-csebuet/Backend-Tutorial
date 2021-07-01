package com.example.TestConfigurationDemo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@TestConfiguration
public class WebClientTestConfiguration {
    @Bean
    public WebClient getWebClient(final WebClient.Builder builder) {
        //customized for running unit tests
        WebClient webClient = builder
                .baseUrl("http://localhost") // <-- local URL
                .build();
        return webClient;
    }
}