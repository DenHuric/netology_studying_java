package org.example;

public class PersonBuilder {
    private String name;
    private String surename;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surename = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Не корректное значение возраста! age < 0");
        }
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surename == null) {
            throw new IllegalStateException("Не заполнены обязательные параметры: Имя или Фамилия");
        }
        return new Person(name,surename,age,address);
    }
}
