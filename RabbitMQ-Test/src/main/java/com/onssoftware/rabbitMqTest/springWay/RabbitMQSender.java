package com.onssoftware.rabbitMqTest.springWay;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${onssoftware.rabbitmq.profileQueue}")
    String profileQueue;

    @Value("${onssoftware.rabbitmq.accountQueue}")
    String accountQueue;

    @Value("${onssoftware.rabbitmq.exchange}")
    String exchange;

    public void send(Profile profile) {
        amqpTemplate.convertAndSend(exchange, profileQueue, profile);
        System.out.println("Sent profile = " + profile);
    }

    public void send(Account account) {
        amqpTemplate.convertAndSend(exchange, accountQueue, account);
        System.out.println("Sent account = " + account);
    }
}
