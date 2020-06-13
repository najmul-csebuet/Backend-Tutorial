package com.onssoftware.rabbitMqTest.workQueues.springWay;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class Consumer {

    private int id;

    public Consumer(int id) {
        this.id = id;
    }

    @RabbitListener(queues = "taskQueue")
    public void receivedMessage(String message) {
        System.out.println("Receiver: " + id + ", Received message: " + message);
    }
}
