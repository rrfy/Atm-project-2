package com.example.myapplication;

import java.io.Serializable;

public class Position implements Serializable {
    private long id = 1;

    private String login = "000";

    private String password = "000";

    private int balance = 0;


    public Position(long id, String login, String password, int balance) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.balance = balance;
    }

    public Position() {

    }

    public void setLogin(String login) {

        this.login = login;
    }

    public void setId(long id) {

        this.id = id;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setBalance(int balance) {

        this.balance = balance;
    }

    public int getBalance() {

        return balance;
    }

    public long getId() {

        return id;
    }

    public String getLogin() {

        return login;
    }

    public String getPassword() {

        return password;
    }
}
