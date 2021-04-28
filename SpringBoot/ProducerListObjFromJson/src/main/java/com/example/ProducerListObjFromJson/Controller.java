package com.example.ProducerListObjFromJson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {
    @GetMapping("/api/users")
    public List<MyUser> getAllUsers() {

        MyUser user1 = new MyUser(1, "Najmul", 20);
        MyAccount ac1 = new MyAccount(1, "AAA", "adas");
        MyAccount ac2 = new MyAccount(1, "AAA", "adas");
        user1.setAccountList(Arrays.asList(ac1, ac2));

        return Arrays.asList(
                user1,
                user1,
                user1
        );
    }
}
