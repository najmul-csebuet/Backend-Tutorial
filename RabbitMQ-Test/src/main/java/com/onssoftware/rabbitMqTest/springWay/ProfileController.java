package com.onssoftware.rabbitMqTest.springWay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/profile")
    public Profile uploadProfile(@RequestBody Profile profile) {

        rabbitMQSender.send(profile);
        return profile;
    }
}
