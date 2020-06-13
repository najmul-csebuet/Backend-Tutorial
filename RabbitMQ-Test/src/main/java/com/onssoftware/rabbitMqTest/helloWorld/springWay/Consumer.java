package com.onssoftware.rabbitMqTest.helloWorld.springWay;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class Consumer {

    @RabbitListener(queues = "simpleQueue")
    public void receivedMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
