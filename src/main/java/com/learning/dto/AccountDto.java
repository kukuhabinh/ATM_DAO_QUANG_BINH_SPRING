package com.learning.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class AccountDto {


    private String accountNumber;


    private Long accountBalance;


    private String atmNumber;


    private String pinCode;

    private String transactionalAccountNumber;

    private Long transactionalMoney;
}
