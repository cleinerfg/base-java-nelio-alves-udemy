package org.example.projects.installmentpayment.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

    private Integer id;
    private LocalDate date;
    private Double totalValue;
    private List<Installment> installments = new ArrayList<>();

    public Contract(Integer id, LocalDate date, Double totalValue) {
        this.id = id;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void addInstallment(Installment installment) {
        installments.add(installment);
    }
}
