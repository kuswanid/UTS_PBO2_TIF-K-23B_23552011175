package org.kuswanid.repository;

import org.kuswanid.model.Transaction;
import org.kuswanid.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    public boolean addTransaction(String id, String customerId, String propertyId, int duration, Timestamp rentalDate, String status, double totalPrice) {
        String sql = "INSERT INTO transactions (id, customer_id, property_id, duration, rental_date, status, total_price) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);
            statement.setString(2, customerId);
            statement.setString(3, propertyId);
            statement.setInt(4, duration);
            statement.setTimestamp(5, rentalDate);
            statement.setString(6, status);
            statement.setDouble(7, totalPrice);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> data = new ArrayList<>();
        String sql = "SELECT * FROM transactions";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                data.add(new Transaction(
                        result.getString("id"),
                        result.getString("customer_id"),
                        result.getString("property_id"),
                        result.getInt("duration"),
                        result.getTimestamp("rental_date"),
                        result.getTimestamp("return_date"),
                        result.getString("status"),
                        result.getDouble("total_price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Transaction getTransactionDetail(String id) {
        String sql = "SELECT * FROM transactions WHERE id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new Transaction(
                        result.getString("id"),
                        result.getString("customer_id"),
                        result.getString("property_id"),
                        result.getInt("duration"),
                        result.getTimestamp("rental_date"),
                        result.getTimestamp("return_date"),
                        result.getString("status"),
                        result.getDouble("total_price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateTransactionStatus(String transactionId, String newStatus) {
        String sql = "UPDATE transactions SET status = ? WHERE id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newStatus);
            statement.setString(2, transactionId);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
