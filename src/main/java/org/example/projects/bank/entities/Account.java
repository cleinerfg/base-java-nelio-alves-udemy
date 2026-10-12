package org.example.projects.bank.entities;

import org.example.projects.bank.exceptions.DailyWithdrawalLimitException;
import org.example.projects.bank.exceptions.InsufficientFoundsException;

public abstract class Account {

    public static final Double DAILY_WITHDRAW_LIMIT = 500.0;

    private Integer number;
    private String holder;
    protected Double balance;

    private Double totalDailyWithdrawn = 0.0;

    protected Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getTotalDailyWithdrawn() {
        return totalDailyWithdrawn;
    }

    public void withdraw(Double amount) {
        if (amount > balance) {
            throw new InsufficientFoundsException(amount);
        }
        if (totalDailyWithdrawn >= DAILY_WITHDRAW_LIMIT) {
            throw new DailyWithdrawalLimitException(DAILY_WITHDRAW_LIMIT);
        }
        balance -= amount;
        totalDailyWithdrawn += amount;
    }
}
