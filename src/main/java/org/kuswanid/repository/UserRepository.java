package org.kuswanid.repository;

import org.kuswanid.model.User;
import org.kuswanid.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    public User login(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new User(
                        result.getString("id"),
                        result.getString("email"),
                        result.getString("name"),
                        result.getString("password"),
                        result.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean register(String id, String email, String name, String password, String role) {
        String sql = "INSERT INTO users (id, email, name, password, role) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);
            statement.setString(2, email);
            statement.setString(3, name);
            statement.setString(4, password);
            statement.setString(5, role);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
