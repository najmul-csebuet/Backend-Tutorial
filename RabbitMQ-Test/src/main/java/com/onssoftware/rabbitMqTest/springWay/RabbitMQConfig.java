package com.onssoftware.rabbitMqTest.springWay;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitMQConfig {

    @Value("${onssoftware.rabbitmq.profileQueue}")
    String profileQueue;

    @Value("${onssoftware.rabbitmq.accountQueue}")
    String accountQueue;

    @Value("${onssoftware.rabbitmq.exchange}")
    String exchange;

    //@Value("${onssoftware.rabbitmq.routingkey}")
    //private String routingkey;

    @Bean
    Queue profileQueue() {
        return new Queue(profileQueue, false);
    }

    @Bean
    Queue accountQueue() {
        return new Queue(accountQueue, false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    /*@Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }*/


    @Bean
    Binding binding1(DirectExchange exchange) {
        return BindingBuilder.bind(profileQueue()).to(exchange).with(profileQueue().getName());
    }

    @Bean
    Binding binding2(DirectExchange exchange) {
        return BindingBuilder.bind(accountQueue()).to(exchange).with(accountQueue().getName());
    }

    //Very important. Should also be same in Consumer
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}

