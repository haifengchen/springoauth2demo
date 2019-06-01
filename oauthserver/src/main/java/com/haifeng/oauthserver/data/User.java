package com.haifeng.oauthserver.data;

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

//    @ElementCollection(targetClass = RolesEnum.class, fetch = FetchType.EAGER)
//    @Enumerated(EnumType.STRING)
//    private Set<RolesEnum> roles = new HashSet<RolesEnum>();
    @Enumerated(EnumType.STRING)
    private RolesEnum role;

    public User(){
        super();
    }

    public User(User user) {
        super();
        this.setId(user.getId());
        this.name = user.getName();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.role = user.getRole();
    }

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

    public RolesEnum getRole() {
        return role;
    }

    public void setRole(RolesEnum role) {
        this.role = role;
    }
}
