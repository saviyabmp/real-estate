package com.bmp.saviya.auth.model;

import javax.persistence.*;
import java.util.Set;
import java.time.LocalDateTime;

@Entity
//"user" is a reserved word in Postgresql. So use "_user" instead.
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String username;

    private String password;

    private String passwordSalt;

    @ManyToMany
    private Set<Role> roles;

    private String email;

    private LocalDateTime accountCreated;

    private LocalDateTime  accountLastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public LocalDateTime  getAccountCreated () {
        return accountCreated;
    }

    public void setAccountCreated(LocalDateTime  accountCreated) {
        this.accountCreated = accountCreated;
    }

    public LocalDateTime  getAccountLastUpdated () {
        return accountLastUpdated;
    }

    public void setAccountLastUpdated(LocalDateTime accountLastUpdated) {
        this.accountLastUpdated = accountLastUpdated;
    }
}
