package org.example.poo.example04.entities;

public class Account {

    public static final double WITHDRAW_FEE = 5.0;

    private final int number;
    private final String holder;
    private double balance;

    public Account(int number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    public Account(int number, String holder, double initialDeposit) {
        this.number = number;
        this.holder = holder;
        deposit(initialDeposit);
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double value) {
        balance += value;
    }

    public void withdraw(double value) {

        double amount = value + Account.WITHDRAW_FEE;

        if (balance < amount) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", holder='" + holder + '\'' +
                ", balance=" + balance +
                '}';
    }
}
