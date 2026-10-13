package org.example.projects.loan.services;

public class BrazilInterestService implements InterestService {

    Double interestRate;

    public BrazilInterestService(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public Double getInterestRate() {
        return interestRate;
    }
}
