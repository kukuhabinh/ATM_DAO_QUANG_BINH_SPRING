package com.learning.repository;


import com.learning.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAtmNumber(String atmNumber);
    Account findByAccountNumber(String accountNumber);
}
