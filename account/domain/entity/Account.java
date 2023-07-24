package com.credibanco.loginback.account.domain.entity;

import com.credibanco.loginback.shared.user.domain.entity.User;
import com.credibanco.loginback.transaction.domain.entity.Transactions;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ORIGINNUMBER")
    private String originNuimber;

    @Column(name = "BALANCE")
    private int balance;

    @CreationTimestamp
    @Column(name = "CREATEDATE")
    private Date createDate;

    @JsonIgnore
    @OneToMany(mappedBy = "id_account", cascade = CascadeType.ALL)
    private List<Transactions> transactions;

    @OneToOne
    @JoinColumn(name = "ID_USER")
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
