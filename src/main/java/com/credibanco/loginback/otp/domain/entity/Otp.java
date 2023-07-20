package com.credibanco.loginback.otp.domain.entity;


<<<<<<< HEAD
import com.credibanco.loginback.user.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
=======
import com.credibanco.loginback.shared.user.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> 5468f53ac6d4d2a45395015ce3066bdd3df3fa1b
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "OTP_CODES")
public class Otp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreationTimestamp
    @Column(name = "D_CREATE")
    private Date dateCreate;
    @Column(name = "OTP")
    private String otp;
    @Column(name = "OPERATION")
    private String operation;
    @Column(name = "COMUNICATION")
    private String comunication;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    @JsonIgnore
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
