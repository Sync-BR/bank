package com.bank.banco.virtual.enums;

public enum SexEnum {
        masculine("Masculino"),
    feminine("Feminino");
    private String gender;
    private int value;

    SexEnum(String gender) {
        this.gender = gender;
        value = ordinal();
    }

    public String getGender() {
        return gender;
    }

    public int getValue() {
        return value;
    }
    //Exemplo para obter os valores da string de um enum
    public static void main(String[] args) {
        SexEnum sexo = SexEnum.masculine;
        System.out.println("Gender: " + sexo.getGender());
        System.out.println("Value: " + sexo.getValue());    }
}
