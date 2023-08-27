package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAdress() {
        return address;
    }

    public String getSurname() {
        return surname;
    }

    public boolean hasAge() {
        if (this.age != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasAddress() {
        if (this.address != null) {
            return true;
        } else {
            return false;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if (hasAge()){
            this.age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(this.age)
                .setAddress(this.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,surname,age,address);
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
