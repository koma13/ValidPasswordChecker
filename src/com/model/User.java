package com.model;

import com.annotation.ValidatePass;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 7863262235394607247L;

    private  transient int  age;

    private String name;

    private String surname;

    private String login;

    @ValidatePass
    private String password;

    public User(Integer age, String name, String surname, String login, String password) {
        this.age = age;
        this.name= name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return age + " " +  name + "  " + surname +" " + login + " " + password ;
    }
}
