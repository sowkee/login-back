package com.credibanco.loginback.shared.user.domain.entity;

import com.credibanco.loginback.otp.domain.entity.Otp;
import com.fasterxml.jackson.annotation.*;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private long id;
    @Column(name= "NAME")
    private String name;
    @Column(name= "LASTNAME")
    private String lastname;
    @Column(name = "EMAIL")
    private String email;
    @Column(name= "PASSWORD")
    private String password;


    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastName) {
        this.lastname = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

}
