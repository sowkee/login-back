package com.credibanco.loginback.shared.user.domain.entity;

import com.fasterxml.jackson.annotation.*;
<<<<<<< HEAD:src/main/java/com/credibanco/loginback/user/domain/entity/Rol.java
import org.springframework.stereotype.Component;
=======
>>>>>>> 5468f53ac6d4d2a45395015ce3066bdd3df3fa1b:src/main/java/com/credibanco/loginback/shared/user/domain/entity/Rol.java


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ROLES")
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ROL_NAME")
    private String rolName;

    @ManyToMany(mappedBy = "rol")
    @JsonIgnore
    private List<User> user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
