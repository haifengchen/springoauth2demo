package com.haifeng.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends  BaseEntity{
    private String name;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String login;

    @NotEmpty
    private String password;

    @ElementCollection(targetClass = RolesEnum.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<RolesEnum> roles = new HashSet<RolesEnum>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RolesEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolesEnum> roles) {
        this.roles = roles;
    }
}
