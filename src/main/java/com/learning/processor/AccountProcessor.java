package com.learning.processor;


import com.learning.Service.AccountService;
import com.learning.converter.AccountConverter;
import com.learning.dto.AccountDto;
import com.learning.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountProcessor {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountConverter accountConverter;

    public boolean loginAccount (AccountDto accountDto) {
        Account entity = accountService.findByAtmNumber(accountDto.getAtmNumber());
        if (entity != null) {
            if (entity.getPinCode().equals(accountDto.getPinCode()) ) {
                return true;
            }
        }
        return false;
    }

    public AccountDto getAccountByAccountNumber(AccountDto accountDto) {
        return accountConverter.toDTO(accountService.findByAccountNumber(accountDto.getAccountNumber()));
    }
}
