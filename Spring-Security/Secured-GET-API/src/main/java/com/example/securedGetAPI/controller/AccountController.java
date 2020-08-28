package com.example.securedGetAPI.controller;

import com.example.securedGetAPI.model.Account;
import com.example.securedGetAPI.response.GetAccountApiResponse;
import com.example.securedGetAPI.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/")
    public String home() {
        return "Welcome";
    }

    @GetMapping("/account/{id}")
    public GetAccountApiResponse getAccount(@PathVariable Long id) {
        Account acc = accountService.getAccount(id);
        return new GetAccountApiResponse(acc);
    }
}
