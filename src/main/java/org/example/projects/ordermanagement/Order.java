package org.example.projects.ordermanagement;

import java.time.OffsetDateTime;

public class Order {

    private Integer id;
    private OffsetDateTime moment;
    private OrderStatus status;

    public Order(Integer id, OffsetDateTime moment, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OffsetDateTime getMoment() {
        return moment;
    }

    public void setMoment(OffsetDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", moment=" + moment +
                ", status=" + status +
                '}';
    }
}
