package com.bank.banco.virtual.model;

import jakarta.persistence.*;

@Entity(name = "CoinsModel")
@Table(name = "coins", schema = "bank")
public class CoinsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "client_money", nullable = false)
    private double money;
    @Column(name = "client_CardLimit")
    private double creditCardLimit;

    public CoinsModel() {
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getCreditCardLimit() {
        return creditCardLimit;
    }

    public void setCreditCardLimit(double creditCardLimit) {
        this.creditCardLimit = creditCardLimit;
    }
}
