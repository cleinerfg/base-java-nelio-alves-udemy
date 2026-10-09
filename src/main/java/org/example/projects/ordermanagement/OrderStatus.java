package org.example.projects.ordermanagement;

public enum OrderStatus {

    PENDING_PAYMENT(1, "Pending Payment", true),
    PROCESSING(2, "Processing", true),
    SHIPPED(3, "Shipped", false),
    DELIVERED(4, "Delivered", false),
    CANCELED(5, "Canceled", false);

    private final int code;
    private final String description;
    private final boolean cancelable;

    OrderStatus(int code, String description, boolean cancelable) {
        this.code = code;
        this.description = description;
        this.cancelable = cancelable;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCancelable() {
        return cancelable;
    }

    public static OrderStatus fromCode(int code) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }
}
