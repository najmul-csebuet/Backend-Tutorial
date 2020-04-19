package com.onssoftware.rabbitMqTest.springWay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/account")
    public Account uploadProfile(@RequestBody Account account) {

        rabbitMQSender.send(account);
        return account;
    }
}
