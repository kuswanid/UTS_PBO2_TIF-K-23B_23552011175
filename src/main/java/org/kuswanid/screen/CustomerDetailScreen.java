package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.model.Customer;
import org.kuswanid.service.CustomerService;

public class CustomerDetailScreen implements Screen {
    private final CustomerService customerService = new CustomerService();
    private final String id;

    public CustomerDetailScreen(String id) {
        this.id = id;
    }

    @Override
    public void render() {
        System.out.println("=== Customer Detail ===");

        Customer customer = customerService.getCustomerDetail(id);
        System.out.println(customer.getName());
        System.out.println(customer.getEmail());
        System.out.println(customer.getPhone());
        System.out.println(customer.getAddress());

        System.out.println();
        System.out.println("1. Edit customer");
        System.out.println("2. Delete Customer");
        System.out.println("0. Back");
    }

    @Override
    public void onInput(int input) {
        switch (input) {
            case 1: {
                Navigator.go(new EditCustomerScreen(id));
                break;
            }
            case 2:{
                boolean result = customerService.deleteCustomer(id);
                if (result) {
                    System.out.println("Customer deleted");
                } else {
                    System.out.println("Delete customer failed");
                }
                Navigator.back();
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
