package com.example.myapplication;

public class Position {
    private long id;
    private String login;
    private String password;
    private int balance;


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
