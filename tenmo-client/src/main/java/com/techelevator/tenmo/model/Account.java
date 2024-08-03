package com.techelevator.tenmo.model;

public class Account {

    private Long accountId;
    private Long userId;
    private double balance;

    public Account(Long accountId, Long userId, double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Your current account balance is: " + balance;
    }

}
