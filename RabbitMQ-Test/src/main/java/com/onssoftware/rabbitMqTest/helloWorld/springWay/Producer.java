package com.onssoftware.rabbitMqTest.helloWorld.springWay;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    //sec min hour dayOfMonth month dayOfWeek
    @Scheduled(cron = "0/3 * * ? * *")
    public void send() {
        String message = "Bismillah";
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("Sent message: " + message);
    }
}
