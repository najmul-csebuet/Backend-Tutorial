package com.onssoftware.DataJpaTutorial.OneToOne;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
//@RequiredArgsConstructor
public class AccountService {
    // will be autowired by @RequiredArgsConstructor

    private final EntityManager entityManager;
    private final AccountRepository accountRepository;

    public AccountService(EntityManager entityManager, AccountRepository accountRepository) {
        this.entityManager = entityManager;
        this.accountRepository = accountRepository;
    }

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
