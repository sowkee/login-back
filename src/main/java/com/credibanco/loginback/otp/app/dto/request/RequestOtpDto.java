package com.credibanco.loginback.otp.app.dto.request;

import com.credibanco.loginback.shared.user.domain.entity.User;
import org.springframework.stereotype.Component;


import java.util.Date;

@Component
public class RequestOtpDto {
    private long id;
    private Date dateCreate;
    private String otp;
    private String operation;
    private String comunication;
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getComunication() {
        return comunication;
    }

    public void setComunication(String comunication) {
        this.comunication = comunication;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
