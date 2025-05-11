package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.model.Customer;
import org.kuswanid.service.CustomerService;

import java.util.Scanner;

public class EditCustomerScreen implements Screen {
    private final CustomerService customerService = new CustomerService();
    private final Scanner scanner = new Scanner(System.in);
    private final String id;

    public EditCustomerScreen(String id) {
        this.id = id;
    }

    @Override
    public void render() {
        System.out.println("=== Edit Customer ===");

        Customer customer = customerService.getCustomerDetail(id);

        System.out.print("Name (" + customer.getName() + "): ");
        String newName = scanner.nextLine();
        if (newName.isEmpty()) newName = customer.getName();

        System.out.print("Email (" + customer.getEmail() + "): ");
        String newEmail = scanner.nextLine();
        if (newEmail.isEmpty()) newEmail = customer.getEmail();

        System.out.print("Phone (" + customer.getPhone() + "): ");
        String newPhone = scanner.nextLine();
        if (newPhone.isEmpty()) newPhone = customer.getPhone();

        System.out.print("Address (" + customer.getAddress() + "): ");
        String newAddress = scanner.nextLine();
        if(newAddress.isEmpty()) newAddress = customer.getAddress();

        boolean result = customerService.updateCustomer(id, newAddress, newEmail, newName, newPhone);
        if (result) {
            System.out.println("Customer updated");
        } else {
            System.out.println("Failed update customer");
        }
        Navigator.back();
    }

    @Override
    public void onInput(int input) {

    }
}
