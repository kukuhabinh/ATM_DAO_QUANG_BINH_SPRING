package com.learning.entities;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name= "account")
@Getter
@Setter
public class Account extends BaseEntity {

    @Column(unique = true)
    private String accountNumber;

    @Column
    private Long accountBalance;

    @Column(unique = true)
    private String atmNumber;

    @Column
    private String pinCode;
}
