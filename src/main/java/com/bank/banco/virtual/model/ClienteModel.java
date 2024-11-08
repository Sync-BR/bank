package com.bank.banco.virtual.model;

import com.bank.banco.virtual.enums.SexEnum;

public class ClienteModel {
    private int id;
    private String name;
    private String cpf;
    private int age;
    private String email;
    private String telephone;
    private String cep;
    private int houseNumber;
    private char houseLetter;
    private SexEnum sex;
    private String photo;
    private LoginModel login;

    public ClienteModel(String name, String cpf, int age, String email, String telephone, String cep, int houseNumber, char houseLetter, SexEnum sex, String photo, LoginModel login) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.email = email;
        this.telephone = telephone;
        this.cep = cep;
        this.houseNumber = houseNumber;
        this.houseLetter = houseLetter;
        this.sex = sex;
        this.photo = photo;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCep() {
        return cep;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public char getHouseLetter() {
        return houseLetter;
    }

    public SexEnum getSex() {
        return sex;
    }

    public String getPhoto() {
        return photo;
    }

    public LoginModel getLogin() {
        return login;
    }
}
