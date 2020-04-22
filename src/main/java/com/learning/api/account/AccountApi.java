package com.learning.api.account;


import com.learning.Service.AccountService;
import com.learning.common.Response;
import com.learning.dto.AccountDto;
import com.learning.processor.AccountProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountApi {

    @Autowired
    private AccountProcessor accountProcessor;

    @PostMapping("/login")
    public Response Login(@RequestBody AccountDto accountDto) {
        Response response = new Response("login");
        if (accountProcessor.loginAccount(accountDto)) {
            return response.successResponse();
        }
        return response.failResponse();
    }
    @GetMapping("/account-infomation")
    public AccountDto getAccInfo(AccountDto accountDto) {
        return accountProcessor.getAccountByAccountNumber(accountDto);
    }

}
