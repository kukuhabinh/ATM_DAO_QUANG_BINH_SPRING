package com.learning.Service;


import com.learning.entities.Account;
import com.learning.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account findByAtmNumber(String atmNumber) {
        return accountRepository.findByAtmNumber(atmNumber);
    }
    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }
    public void save(Account account) {
        accountRepository.save(account);
    }
}
