package com.onssoftware.OneToOneMapping.service;

import com.onssoftware.OneToOneMapping.model.Account;
import com.onssoftware.OneToOneMapping.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    // will be autowired by @RequiredArgsConstructor
    private final AccountRepository accountRepository;

    public Account save(Account acc) {
        return accountRepository.save(acc);
    }

    public void delete(long l) {
        accountRepository.deleteById(l);
    }

    public Account findOne() {
        return accountRepository.findAll().get(0);
    }
}
