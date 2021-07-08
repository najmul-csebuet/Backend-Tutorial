package com.onssoftware.rabbitMQConsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "${onssoftware.rabbitmq.queue}")
    public void receivedMessage(Profile profile) {
      System.out.println("Received Message From RabbitMQ: " + profile);
    }
}