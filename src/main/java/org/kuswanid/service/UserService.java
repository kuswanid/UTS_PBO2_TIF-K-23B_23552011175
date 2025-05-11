package org.kuswanid.service;

import org.kuswanid.model.User;
import org.kuswanid.repository.UserRepository;

import java.util.UUID;

public class UserService {
    private static UserService instance;
    private final UserRepository repository = new UserRepository();
    private User currentUser;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean login(String email, String password) {
        User userResult = repository.login(email, password);
        if (userResult != null) {
            currentUser = userResult;
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        currentUser = null;
    }

    public boolean register(String email, String name, String password) {
        String id = UUID.randomUUID().toString();
        String role = "admin";
        return repository.register(id, email, name, password, role);
    }
}
