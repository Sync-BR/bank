package com.bank.banco.virtual.model;

import jakarta.persistence.*;

@Entity(name = "LoginModel")
@Table(name = "login", schema = "bank")
public class LoginModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cliente_username", nullable = false )
    private String username;
    @Column(name = "cliente_password", nullable = false )
    private String password;

    public LoginModel() {
    }

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
