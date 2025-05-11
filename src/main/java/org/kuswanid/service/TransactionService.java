package org.kuswanid.service;

import org.kuswanid.model.Transaction;
import org.kuswanid.repository.TransactionRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class TransactionService {
    private final TransactionRepository repository = new TransactionRepository();

    public boolean addTransaction(String customerId, String propertyId, int duration, double totalPrice) {
        String id = UUID.randomUUID().toString();
        Timestamp rentalDate = new Timestamp(System.currentTimeMillis());
        String status = "rented";
        return repository.addTransaction(id, customerId, propertyId, duration, rentalDate, status, totalPrice);
    }

    public List<Transaction> getAllTransactions() {
        return repository.getAllTransactions();
    }

    public Transaction getTransactionDetail(String id) {
        return repository.getTransactionDetail(id);
    }

    public boolean updateTransactionStatus(String transactionId, String newStatus) {
        return repository.updateTransactionStatus(transactionId, newStatus);
    }
}
