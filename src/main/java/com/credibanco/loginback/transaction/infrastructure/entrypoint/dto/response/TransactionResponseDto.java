package com.credibanco.loginback.transaction.infrastructure.entrypoint.dto.response;

import org.springframework.stereotype.Component;
import java.sql.Date;

@Component
public class TransactionResponseDto {

    private long id;
    private String receiver;
    private String balance;
    private String reference;
    private Date creationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
