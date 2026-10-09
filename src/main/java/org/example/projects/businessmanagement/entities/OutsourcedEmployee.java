package org.example.projects.businessmanagement.entities;

public class OutsourcedEmployee extends Employee {

    private double additionalCost;

    public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, double additionalCost) {
        super(name, hours, valuePerHour);
        this.additionalCost = additionalCost;
    }

    public double getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(double additionalCost) {
        this.additionalCost = additionalCost;
    }

    @Override
    public Double payment() {
        return super.payment() + (additionalCost * 1.1);
    }
}
