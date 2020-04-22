package com.learning.converter;


import com.learning.dto.AccountDto;
import com.learning.entities.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter implements IDTO<AccountDto>,IEntity<Account> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AccountDto toDTO(Object entity) {
        AccountDto dto = modelMapper.map(entity,AccountDto.class);
        return dto;
    }

    @Override
    public Account toEntity(Object dto) {
        Account entity = modelMapper.map(dto,Account.class);
        return entity;
    }
}
