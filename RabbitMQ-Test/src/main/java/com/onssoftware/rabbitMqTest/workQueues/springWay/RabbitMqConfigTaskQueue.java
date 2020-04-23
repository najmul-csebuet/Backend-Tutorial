package com.onssoftware.rabbitMqTest.workQueues.springWay;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfigTaskQueue {

    @Bean
    Queue taskQueue() {
        return new Queue("taskQueue", false);
    }

    @Bean
    Producer producer1() {
        return new Producer(1);
    }

    //@Bean
    Producer producer2() {
        return new Producer(2);
    }

    @Bean
    Consumer consumer1() {
        return new Consumer(1);
    }

    @Bean
    Consumer consumer2() {
        return new Consumer(2);
    }

    @Bean
    Consumer consumer3() {
        return new Consumer(3);
    }
}
