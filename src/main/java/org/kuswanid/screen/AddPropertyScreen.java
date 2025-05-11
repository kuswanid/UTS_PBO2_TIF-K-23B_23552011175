package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.service.PropertyService;

import java.util.Scanner;

public class AddPropertyScreen implements Screen {
    private final PropertyService propertyService = new PropertyService();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void render() {
        System.out.println("=== Add Property ===");

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Area: ");
        Double area = scanner.nextDouble();
        System.out.print("Price: ");
        double price = scanner.nextDouble();

        boolean result = propertyService.addProperty(address, area, name, price, type);
        if (result) {
            System.out.println("New property added");
        } else {
            System.out.println("Failed add property");
        }
        Navigator.back();
    }

    @Override
    public void onInput(int input) {
    }
}
