package com.onssoftware.RelationalDbExercise.controller;

import com.onssoftware.RelationalDbExercise.model.MyUser;
import com.onssoftware.RelationalDbExercise.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private MyUserService myUserService;

    @PostMapping("api/v1/users")
    public ResponseEntity<MyUser> addUser(@RequestBody MyUser myUser) {
        return myUserService.saveUser(myUser);
    }

    @GetMapping("api/v1/users")
    public ResponseEntity<List<MyUser>> addUser() {
        return myUserService.getAllUser();
    }

    @GetMapping("api/v1/users/{id}")
    public ResponseEntity<MyUser> getUser(@PathVariable Long id) {
        return myUserService.getUser(id);
    }
}
