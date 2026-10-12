package org.example.projects.bank.exceptions;

public class DailyWithdrawalLimitException extends RuntimeException {
    public DailyWithdrawalLimitException(double dailyWithdrawalLimit) {
        super("Daily Withdrawal Limit Exceeded, daily limit:" + dailyWithdrawalLimit);
    }
}
