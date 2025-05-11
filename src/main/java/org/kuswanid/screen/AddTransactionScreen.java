package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.model.Customer;
import org.kuswanid.model.Property;
import org.kuswanid.service.CustomerService;
import org.kuswanid.service.PropertyService;
import org.kuswanid.service.TransactionService;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class AddTransactionScreen implements Screen {
    private final CustomerService customerService = new CustomerService();
    private final PropertyService propertyService = new PropertyService();
    private final TransactionService transactionService = new TransactionService();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void render() {
        System.out.println("=== Add Transaction ===");

        System.out.println("◼ Available Property");
        List<Property> properties = propertyService.getAllProperties().stream().filter(Property::isAvailable).toList();
        for (int i = 0; i < properties.size(); i++) {
            System.out.println(i + 1 + ". " + properties.get(i).getName());
        }
        System.out.print("Select Property: ");
        int propertyAnswer = scanner.nextInt();
        Property selectedProperty = properties.get(propertyAnswer - 1);

        System.out.println();
        System.out.println("◼ Available Customer");
        List<Customer> customers = customerService.getAllCustomers();
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(i + 1 + ". " + customers.get(i).getName());
        }
        System.out.print("Select Customer: ");
        int customerAnswer = scanner.nextInt();
        Customer selectedCustomer = customers.get(customerAnswer - 1);

        System.out.println();
        System.out.print("◼ Rental duration (day): ");
        int durationAnswer = scanner.nextInt();

        System.out.println();
        System.out.println("--- Transaction Detail ---");
        System.out.println("Property    : " + selectedProperty.getName());
        System.out.println("Customer    : " + selectedCustomer.getName());
        System.out.println("Duration    : " + durationAnswer + " days");
        System.out.println("Total Price : Rp" + new DecimalFormat("#").format(selectedProperty.getPrice() * durationAnswer));

        System.out.println();
        System.out.print("Continue rental (y/n)? ");
        String rentalAnswer = scanner.next();

        if (rentalAnswer.equals("y")) {
            boolean result = transactionService.addTransaction(
                    selectedCustomer.getId(),
                    selectedProperty.getId(),
                    durationAnswer,
                    selectedProperty.getPrice() * durationAnswer
            );
            if (result) {
                System.out.println("New transaction added");
            } else {
                System.out.println("Failed add transaction");
            }
        } else {
            System.out.println("Transaction canceled");
        }
        Navigator.back();
    }

    @Override
    public void onInput(int input) {
    }
}
