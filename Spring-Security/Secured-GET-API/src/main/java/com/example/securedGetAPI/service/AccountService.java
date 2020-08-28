package com.example.securedGetAPI.service;

import com.example.securedGetAPI.model.Account;
import com.example.securedGetAPI.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account getAccount(Long id) {
        Optional<Account> byId = accountRepository.findById(id);
        if (byId.isPresent()) return byId.get();
        Account account = new Account(id, "Survhi", "1234", "USER");
        return account;
    }

    public Account getAccount(String userName) {
        Account byId = accountRepository.findByName(userName);
        if (byId != null) return byId;
        Account account = new Account(1l, userName, "1234", "USER");
        return account;
    }
}
