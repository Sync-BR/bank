package com.bank.banco.virtual.model;

import com.bank.banco.virtual.enums.SexEnum;
import jakarta.persistence.*;

@Entity(name = "ClienteModel")
@Table(name = "cliente", schema = "bank")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cliente_name", nullable = false )
    private String name;
    @Column(name = "cliente_cpf", nullable = false )
    private String cpf;
    @Column(name = "cliente_age", nullable = false )
    private int age;
    @Column(name = "cliente_email", nullable = false )
    private String email;
    @Column(name = "cliente_telephone", nullable = false )
    private String telephone;
    @Column(name = "cliente_cep", nullable = false )
    private String cep;
    @Column(name = "cliente_house_number", nullable = false )
    private int houseNumber;
    @Column(name = "cliente_house_letter", nullable = false )
    private char houseLetter;
    @Enumerated(EnumType.STRING)
    @Column(name = "cliente_sex", nullable = false )
    private SexEnum sex;
    @Column(name = "cliente_photo", nullable = false )
    private String photo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private LoginModel login;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coins_id", referencedColumnName = "id")
    private CoinsModel coins;
    @Override
    public String toString() {
        return "ClienteModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", cep='" + cep + '\'' +
                ", houseNumber=" + houseNumber +
                ", houseLetter=" + houseLetter +
                ", sex=" + sex +
                ", photo='" + photo + '\'' +
                ", login=" + login +
                '}';
    }

    public ClienteModel() {
    }

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

    public ClienteModel(String name, String cpf, int age, String email, String telephone, String cep, int houseNumber, char houseLetter, SexEnum sex, String photo, LoginModel login, CoinsModel coins) {
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
        this.coins = coins;
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

    public CoinsModel getCoins() {
        return coins;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setHouseLetter(char houseLetter) {
        this.houseLetter = houseLetter;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setLogin(LoginModel login) {
        this.login = login;
    }
}
