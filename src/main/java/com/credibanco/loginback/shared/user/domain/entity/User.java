package com.credibanco.loginback.shared.user.domain.entity;

import com.credibanco.loginback.otp.domain.entity.Otp;
import com.fasterxml.jackson.annotation.*;
<<<<<<< HEAD:src/main/java/com/credibanco/loginback/user/domain/entity/User.java

=======
>>>>>>> 5468f53ac6d4d2a45395015ce3066bdd3df3fa1b:src/main/java/com/credibanco/loginback/shared/user/domain/entity/User.java
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private long id;
    @Column(name= "NAME")
    private String name;
    @Column(name= "LASTNAME")
    private String lastname;
    @Column (name= "EMAIL")
    private String email;
    @Column(name= "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name= "PASSWORD")
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Otp otp;
<<<<<<< HEAD:src/main/java/com/credibanco/loginback/user/domain/entity/User.java

=======
>>>>>>> 5468f53ac6d4d2a45395015ce3066bdd3df3fa1b:src/main/java/com/credibanco/loginback/shared/user/domain/entity/User.java
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROL_ID")
    )
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
<<<<<<< HEAD:src/main/java/com/credibanco/loginback/user/domain/entity/User.java

=======
>>>>>>> 5468f53ac6d4d2a45395015ce3066bdd3df3fa1b:src/main/java/com/credibanco/loginback/shared/user/domain/entity/User.java
}
