package com.credibanco.loginback.account.infrastructure.dto.request;

import com.credibanco.loginback.shared.user.domain.entity.User;
import com.credibanco.loginback.transaction.domain.entity.Transactions;

import java.util.Date;
import java.util.List;

public class RequestAccountDto {


    private long id;
    private String originNuimber;
    private int balance;
    private Date createDate;
    private List<Transactions> transactions;
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginNuimber() {
        return originNuimber;
    }

    public void setOriginNuimber(String originNuimber) {
        this.originNuimber = originNuimber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
