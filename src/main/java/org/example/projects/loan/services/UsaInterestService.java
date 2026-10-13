package org.example.projects.loan.services;

public class UsaInterestService implements InterestService {

    Double interestRate;

    public UsaInterestService(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public Double getInterestRate() {
        return interestRate;
    }
}
