package org.kuswanid.model;

public class User {
    private String id;
    private final String email;
    private final String name;
    private String password;
    private String role;

    public User(String id, String email, String name, String password, String role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
