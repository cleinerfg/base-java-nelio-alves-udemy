package org.example.projects.bank.entities;

public final class BusinessAccount extends Account {

    public static final Double LOAN_FEE = 10.0;

    private Double loanLimit;

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if (amount > loanLimit) {
            System.out.println("Loan denied: amount exceeds limit");
            return;
        }
        balance += amount - LOAN_FEE;
        System.out.println("Loan approved: " + amount);
    }
}
