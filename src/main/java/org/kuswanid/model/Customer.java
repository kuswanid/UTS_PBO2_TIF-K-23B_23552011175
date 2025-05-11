package org.kuswanid.model;

public class Customer {
    private final String id;
    private final String address;
    private final String email;
    private final String name;
    private final String phone;

    public Customer(String id, String address, String email, String name, String phone) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
