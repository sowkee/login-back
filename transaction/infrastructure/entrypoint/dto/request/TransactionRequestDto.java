package com.credibanco.loginback.transaction.infrastructure.entrypoint.dto.request;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import com.credibanco.loginback.account.domain.entity.Account;

import java.sql.Date;

import javax.persistence.*;

@Component
public class TransactionRequestDto {

	private long id;
	private Date createDate;
	private String originNumber;
	private String destinationAccount;
	private int amount;
	private String reference;
	private String description;
	private Account id_account;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOriginNumber() {
		return originNumber;
	}

	public void setOriginNumber(String originNumber) {
		this.originNumber = originNumber;
	}

	public String getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(String destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Account getId_account() {
		return id_account;
	}

	public void setId_account(Account id_account) {
		this.id_account = id_account;
	}
}
