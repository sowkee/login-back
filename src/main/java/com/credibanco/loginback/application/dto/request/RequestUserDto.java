package com.credibanco.loginback.application.dto.request;

import com.credibanco.loginback.domain.model.Otp;
import com.credibanco.loginback.domain.model.Rol;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestUserDto {

	@JsonProperty("id")
	private long id;
    
	@JsonProperty("name")
    private String name;
    
    @JsonProperty("lastName")
    private String lastName;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    
    @JsonProperty("password")
    private String password;
    @JsonProperty("otp")
    @JsonIgnore
    private Otp otp;
    @JsonProperty("rol")
    @JsonIgnore
    private List<Rol> rol;


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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Otp getOtp() {
        return otp;
    }

    public void setOtp(Otp otp) {
        this.otp = otp;
    }

    public List<Rol> getRol() {
        return rol;
    }

    public void setRol(List<Rol> rol) {
        this.rol = rol;
    }
}
