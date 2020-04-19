package com.onssoftware.rabbitMqTest.helloWorld.springWay;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    Queue queue() {
        return new Queue("simpleQueue", false);
    }
}
