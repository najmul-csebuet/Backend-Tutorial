package com.onssoftware.rabbitMqTest.workQueues.springWay;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

//@Component
public class Producer {

    private int id;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("taskQueue")
    private Queue queue;

    public Producer(int id) {
        this.id = id;
    }

    //sec min hour dayOfMonth month dayOfWeek
    @Scheduled(cron = "0/3 * * ? * *")
    public void send() {
        String message = "Bismillah";
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("Sender: " + id + ", Sent message: " + message);
    }
}
