package com.credibanco.loginback.user.infrastructure.entrypoint.dto.request;

import com.credibanco.loginback.otp.domain.entity.Otp;
import com.credibanco.loginback.user.domain.entity.Rol;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestUserDto {

	@JsonProperty("id")
	private long id;
    
	@JsonProperty("name")
    @NotNull
    private String name;
    
    @JsonProperty("lastname")
    @NotNull
    private String lastname;
    
    @JsonProperty("email")
    @Email(regexp = "^[^@]+@[^@]+\\.[^@]+$", message = "Invalid Email, ej.(email@email.com)")
    private String email;
    
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    
    @JsonProperty("password")
    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password invalid, ej.(Ejpl1234*)")
    private String password;
    @JsonProperty("otp")
    private Otp otp;
    @JsonProperty("rol")
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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