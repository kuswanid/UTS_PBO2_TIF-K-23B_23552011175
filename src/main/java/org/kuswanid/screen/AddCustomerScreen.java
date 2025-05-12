package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.service.CustomerService;

import java.util.Scanner;

public class AddCustomerScreen implements Screen {
    private final CustomerService customerService = new CustomerService();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void render() {
        System.out.println("=== Add Customer ===");

        System.out.print("Name    : ");
        String name = scanner.nextLine();
        System.out.print("Email   : ");
        String email = scanner.nextLine();
        System.out.print("Phone   : ");
        String phone = scanner.nextLine();
        System.out.print("Address : ");
        String address = scanner.nextLine();

        boolean result = customerService.addCustomer(address, email, name, phone);
        if (result) {
            System.out.println("New customer added");
        } else {
            System.out.println("Failed add customer");
        }
        Navigator.back();
    }

    @Override
    public void onInput(int input) {
    }
}
