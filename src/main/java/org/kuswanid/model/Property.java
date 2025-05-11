package org.kuswanid.model;

public class Property {
    private final String id;
    private final String address;
    private final double area;
    private final boolean available;
    private final String name;
    private final double price;
    private final String type;

    public Property(String id, String address, double area, boolean available, String name, double price, String type) {
        this.id = id;
        this.address = address;
        this.area = area;
        this.available = available;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
