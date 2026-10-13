package org.example.projects.installmentpayment.services;

public class PaypalPaymentService implements OnlinePaymentService {

    @Override
    public double paymentFee(Double amount) {
        return amount * 0.02;
    }

    @Override
    public double interest(Double amount, int months) {
        return amount * 0.01 * months;
    }
}
