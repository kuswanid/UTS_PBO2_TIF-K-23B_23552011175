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

public class TransactionDetailScreen implements Screen {
    private final CustomerService customerService = new CustomerService();
    private final PropertyService propertyService = new PropertyService();
    private final TransactionService transactionService = new TransactionService();
    private final String id;

    public TransactionDetailScreen(String id) {
        this.id = id;
    }

    @Override
    public void render() {
        System.out.println("=== Transaction Detail ===");

        Transaction transaction = transactionService.getTransactionDetail(id);
        Customer customer = customerService.getCustomerDetail(transaction.getCustomerId());
        Property property = propertyService.getPropertyDetail(transaction.getPropertyId());

        System.out.println("Property    : " + property.getName());
        System.out.println("Customer    : " + customer.getName());
        System.out.println("Duration    : " + transaction.getDuration() + " days");
        System.out.println("Total Price : Rp" + new DecimalFormat("#").format(transaction.getTotalPrice()));
        System.out.println("Status      : " + transaction.getStatus());

        System.out.println();
        if (transaction.getStatus().equals("rented")) {
            System.out.println("1. Finish Transaction");
        }
        if (!transaction.getStatus().equals("finished") && !transaction.getStatus().equals("canceled")) {
            System.out.println("2. Cancel Transaction");
        }
        System.out.println("0. Back");
    }

    @Override
    public void onInput(int input) {
        switch (input) {
            case 1: {
                boolean result = transactionService.updateTransactionStatus(id, "finished");
                if (result) {
                    Navigator.refresh();
                }
                break;
            }
            case 2: {
                boolean result = transactionService.updateTransactionStatus(id, "canceled");
                if (result) {
                    Navigator.refresh();
                }
                break;
            }
            case 0: {
                Navigator.back();
                break;
            }
            default: {
                System.out.println("Invalid input");
            }
        }
    }
}
