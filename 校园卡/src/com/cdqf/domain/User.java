package com.cdqf.domain;

public class User {
    private double balance;
    private double consumption;
    private double recharge;
    private String cardid;
    private String user;
    private String password;

    public User() {
    }

    public User(double balance, double consumption, double recharge, String cardid, String user, String password) {
        this.balance = balance;
        this.consumption = consumption;
        this.recharge = recharge;
        this.cardid = cardid;
        this.user = user;
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getRecharge() {
        return recharge;
    }

    public void setRecharge(double recharge) {
        this.recharge = recharge;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "balance=" + balance +
                ", consumption=" + consumption +
                ", recharge=" + recharge +
                ", cardid='" + cardid + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
