package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.model.Customer;
import org.kuswanid.service.CustomerService;

import java.util.List;

public class CustomersScreen implements Screen {
    private final CustomerService customerService = new CustomerService();
    private List<Customer> customers;

    @Override
    public void render() {
        System.out.println("=== Customers ===");

        customers = customerService.getAllCustomers();

        if(customers.isEmpty()) {
            System.out.println("No customers data");
            System.out.println();
        }
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(i + 1 + ". " + customers.get(i).getName());
            System.out.println("   " + customers.get(i).getEmail());
            System.out.println();
        }

        System.out.println(customers.size() + 1 + ". Add New Customer");
        System.out.println("0. Back");
    }

    @Override
    public void onInput(int input) {
        if (input > 0 && input <= customers.size()) {
            String id = customers.get(input - 1).getId();
            Navigator.go(new CustomerDetailScreen(id));
        } else if (input == customers.size() + 1) {
            Navigator.go(new AddCustomerScreen());
        } else if (input == 0) {
            Navigator.back();
        } else {
            System.out.println("Invalid input");
        }
    }
}
