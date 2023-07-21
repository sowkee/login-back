package com.credibanco.loginback.transaction.domain.entity;

import org.hibernate.annotations.CreationTimestamp;

import com.credibanco.loginback.account.domain.entity.Account;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @CreationTimestamp
    @Column(name = "CREATEDATE")
    private Date createDate;
    
    @Column(name = "ORIGINNUMBER")
    private String originNumber;
    
    @Column(name = "DESTINATIONACCOUNT")
    private String destinationAccount;
    
    @Column(name = "AMOUNT")
    private int amount;
    
    @Column(name = "REFERENCE")
    private String reference;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "ID_ACCOUNT")
    private Account id_account;
    
    
    
}
