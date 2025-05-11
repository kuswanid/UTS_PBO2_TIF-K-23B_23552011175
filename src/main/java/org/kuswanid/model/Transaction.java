package org.kuswanid.model;

import java.sql.Timestamp;

public class Transaction {
    private final String id;
    private final String customerId;
    private final String propertyId;
    private final int duration;
    private Timestamp rentalDate;
    private Timestamp returnDate;
    private final String status;
    private final double totalPrice;

    public Transaction(String id, String customerId, String propertyId, int duration, Timestamp rentalDate, Timestamp returnDate, String status, double totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.propertyId = propertyId;
        this.duration = duration;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
