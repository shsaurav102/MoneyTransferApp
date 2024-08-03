package com.techelevator.tenmo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class Account {

    private Long accountId;
    private Long userId;
    @Positive(message = "Balance should not be greater than 0")
    private double balance;
    @NotEmpty
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setBalance(double balance) {
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

    /*@java.lang.Override
    public java.lang.String toString() {
        return "Your current account balance is: " + balance;
    }*/
}