package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.model.Customer;
import org.kuswanid.model.Property;
import org.kuswanid.model.Transaction;
import org.kuswanid.service.CustomerService;
import org.kuswanid.service.PropertyService;
import org.kuswanid.service.TransactionService;

import java.text.DecimalFormat;
import java.util.List;

public class TransactionsScreen implements Screen {
    private final CustomerService customerService = new CustomerService();
    private final PropertyService propertyService = new PropertyService();
    private final TransactionService transactionService = new TransactionService();
    private List<Transaction> transactions;

    @Override
    public void render() {
        System.out.println("=== Transactions ===");

        transactions = transactionService.getAllTransactions();

        if (transactions.isEmpty()) {
            System.out.println("No transaction data");
            System.out.println();
        }
        for (int i = 0; i < transactions.size(); i++) {
            Customer customer = customerService.getCustomerDetail(transactions.get(i).getCustomerId());
            Property property = propertyService.getPropertyDetail(transactions.get(i).getPropertyId());

            System.out.println(i + 1 + ". " + property.getName());
            System.out.println("   Customer: " + customer.getName());
            System.out.println("   Rp" + new DecimalFormat("#").format(transactions.get(i).getTotalPrice()));
            System.out.println("   Status: " + transactions.get(i).getStatus());
            System.out.println();
        }

        System.out.println(transactions.size() + 1 + ". Add New Transaction");
        System.out.println("0. Back");
    }

    @Override
    public void onInput(int input) {
        if (input > 0 && input <= transactions.size()) {
            String id = transactions.get(input - 1).getId();
            Navigator.go(new TransactionDetailScreen(id));
        } else if (input == transactions.size() + 1) {
            Navigator.go(new AddTransactionScreen());
        } else if (input == 0) {
            Navigator.back();
        } else {
            System.out.println("Invalid input");
        }
    }
}
