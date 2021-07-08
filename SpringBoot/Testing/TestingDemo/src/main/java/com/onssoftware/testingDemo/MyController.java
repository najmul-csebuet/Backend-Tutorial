package com.onssoftware.testingDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/hello")
    public String test(@RequestParam String name) {
        return String.format("Bismillah! %s", name);
    }
}
