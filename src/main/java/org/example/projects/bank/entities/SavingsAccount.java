package org.example.projects.bank.entities;

public class SavingsAccount extends Account {

    public static final Double WITHDRAW_FEE = 2.0;

    private Double interestRate;

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }

    @Override
    public final void withdraw(Double amount) {
        super.withdraw(amount + WITHDRAW_FEE);
    }
}
