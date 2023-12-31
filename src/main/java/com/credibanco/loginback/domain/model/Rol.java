package com.credibanco.loginback.domain.model;

import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ROLES")
@Component
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ROL_NAME")
    private String rolName;

    @ManyToMany(mappedBy = "rol")
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
