package com.learning.processor;

import com.learning.Service.AccountService;
import com.learning.common.Response;
import com.learning.converter.AccountConverter;
import com.learning.dto.AccountDto;
import com.learning.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionProcessor {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountConverter converter;

    public Response transferMoney(AccountDto accountDto) {
        if (accountDto.getTransactionalMoney() > accountDto.getAccountBalance()){
            return new Response("not enough money").failResponse();
        }
        Account transactionalAccount = accountService.findByAccountNumber(accountDto.getTransactionalAccountNumber());
        if (transactionalAccount == null) {
            return new Response("wrong transactional account").failResponse();
        }
        transactionalAccount.setAccountBalance(transactionalAccount.getAccountBalance() + accountDto.getTransactionalMoney());
        Account account = accountService.findByAccountNumber(accountDto.getAccountNumber());
        account.setAccountBalance(account.getAccountBalance() - accountDto.getTransactionalMoney());
        accountService.save(account);
        accountService.save(transactionalAccount);
        return new Response().successResponse();
    }
    public Response withdrawal(AccountDto accountDto) {
        if (accountDto.getTransactionalMoney() > accountDto.getAccountBalance()) {
            return new Response("not enough money").failResponse();
        }
        Account account = accountService.findByAccountNumber(accountDto.getAccountNumber());
        if (account == null) {
            return new Response("no account found").failResponse();
        }
        account.setAccountBalance( account.getAccountBalance() - accountDto.getTransactionalMoney());
        accountService.save(account);
        return new Response().successResponse();
    }
}
