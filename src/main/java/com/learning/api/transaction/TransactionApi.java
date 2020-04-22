package com.learning.api.transaction;

import com.learning.common.Response;
import com.learning.dto.AccountDto;
import com.learning.processor.TransactionProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionApi {

    @Autowired
    private TransactionProcessor transactionProcessor;

    @PostMapping("/transfer")
    public Response transferMoney(@RequestBody AccountDto accountDto){
            return transactionProcessor.transferMoney(accountDto);
    }

    @PostMapping("withdrawal")
    public Response makeWithdrawal(@RequestBody AccountDto accountDto) {
        return transactionProcessor.withdrawal(accountDto);
    }
}
