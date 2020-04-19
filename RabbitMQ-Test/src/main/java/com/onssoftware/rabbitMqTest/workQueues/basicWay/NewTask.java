package com.onssoftware.rabbitMqTest.workQueues.basicWay;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class NewTask {
    private final static String TASK_QUEUE_NAME = "task_queue";

    public void sendMessage(String message) throws IOException, TimeoutException {

        //every dot represent 1 sec of work.
        message += ".....";

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("192.168.43.21");
        factory.setUsername("test");
        factory.setPassword("1234");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            boolean durable = true;
            channel.queueDeclare("task_queue", durable, false, false, null);

            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
