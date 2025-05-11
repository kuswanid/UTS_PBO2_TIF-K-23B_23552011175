package org.kuswanid.repository;

import org.kuswanid.model.Property;
import org.kuswanid.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyRepository {
    public boolean addProperty(String id, String address, Double area, boolean available, String name, Double price, String type) {
        String sql = "INSERT INTO properties (id, address, area, available, name, price, type) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);
            statement.setString(2, address);
            statement.setDouble(3, area);
            statement.setBoolean(4, available);
            statement.setString(5, name);
            statement.setDouble(6, price);
            statement.setString(7, type);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProperty(String id) {
        String sql = "DELETE FROM properties WHERE id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Property> getAllProperties() {
        List<Property> data = new ArrayList<>();
        String sql = "SELECT * FROM properties";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                data.add(new Property(
                        result.getString("id"),
                        result.getString("address"),
                        result.getDouble("area"),
                        result.getBoolean("available"),
                        result.getString("name"),
                        result.getDouble("price"),
                        result.getString("type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Property getPropertyDetail(String id) {
        String sql = "SELECT * FROM properties WHERE id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new Property(
                        result.getString("id"),
                        result.getString("address"),
                        result.getDouble("area"),
                        result.getBoolean("available"),
                        result.getString("name"),
                        result.getDouble("price"),
                        result.getString("type")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateProperty(String id, String address, Double area, boolean available, String name, Double price, String type) {
        String sql = "UPDATE properties SET address = ?, area = ?, available = ?, name = ?, price = ?, type = ? WHERE id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, address);
            statement.setDouble(2, area);
            statement.setBoolean(3, available);
            statement.setString(4, name);
            statement.setDouble(5, price);
            statement.setString(6, type);
            statement.setString(7, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
