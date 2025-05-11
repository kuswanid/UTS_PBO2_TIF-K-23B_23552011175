package org.kuswanid.repository;

import org.kuswanid.model.Customer;
import org.kuswanid.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    public boolean addCustomer(String id, String address, String email, String name, String phone) {
        String sql = "INSERT INTO customers (id, address, email, name, phone) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);
            statement.setString(2, address);
            statement.setString(3, email);
            statement.setString(4, name);
            statement.setString(5, phone);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCustomer(String id) {
        String sql = "DELETE FROM customers WHERE id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> data = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                data.add(new Customer(
                        result.getString("id"),
                        result.getString("address"),
                        result.getString("email"),
                        result.getString("name"),
                        result.getString("phone")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Customer getCustomerDetail(String id) {
        String sql = "SELECT * FROM customers WHERE id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new Customer(
                        result.getString("id"),
                        result.getString("address"),
                        result.getString("email"),
                        result.getString("name"),
                        result.getString("phone")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateCustomer(String id, String address, String email, String name, String phone) {
        String sql = "UPDATE customers SET address = ?, email = ?, name = ?, phone = ? WHERE id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, address);
            statement.setString(2, email);
            statement.setString(3, name);
            statement.setString(4, phone);
            statement.setString(5, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
