package org.example.projects.ordermanagement;

import java.time.OffsetDateTime;

public class App {

    public static void main(String[] args) {

        Order order = new Order(2356, OffsetDateTime.now(), OrderStatus.PENDING_PAYMENT);
        System.out.println(order);

        String updateStatus = "PROCESSING";
        OrderStatus newStatus = OrderStatus.valueOf(updateStatus);
        order.setStatus(newStatus);

        System.out.println("----- Details Order -----");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Order Date: " + order.getMoment());

        System.out.println("--> Order Status details: ");
        System.out.println("Order Status Code: " + order.getStatus().getCode());
        System.out.println("Order Status Description: " + order.getStatus().getDescription());
        System.out.println("Order Status Cancelable: " + order.getStatus().isCancelable());


    }
}
