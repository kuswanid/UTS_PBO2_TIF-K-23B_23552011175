package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.model.Property;
import org.kuswanid.service.PropertyService;

import java.util.Scanner;

public class EditPropertyScreen implements Screen {
    private final PropertyService propertyService = new PropertyService();
    private final Scanner scanner = new Scanner(System.in);
    private final String id;

    public EditPropertyScreen(String id) {
        this.id = id;
    }

    @Override
    public void render() {
        System.out.println("=== Edit Property ===");

        Property property = propertyService.getPropertyDetail(id);

        System.out.print("Name (" + property.getName() + "): ");
        String newName = scanner.nextLine();
        if (newName.isEmpty()) newName = property.getName();

        System.out.print("Type (" + property.getType() + "): ");
        String newType = scanner.nextLine();
        if (newType.isEmpty()) newType = property.getType();

        System.out.print("Address (" + property.getAddress() + "): ");
        String newAddress = scanner.nextLine();
        if (newAddress.isEmpty()) newAddress = property.getAddress();

        System.out.print("Area (" + property.getArea() + " m²): ");
        double newArea = scanner.nextDouble();

        System.out.print("Price (" + property.getPrice() + "): ");
        double newPrice = scanner.nextDouble();

        if (property.isAvailable()) {
            System.out.print("Available (y): ");
        } else {
            System.out.print("Available (n): ");
        }
        String newAvailable = scanner.next();

        boolean result = propertyService.updateProperty(
                property.getId(),
                newAddress,
                newArea,
                newAvailable.equals("y"),
                newName,
                newPrice,
                newType
        );
        if (result) {
            System.out.println("Property updated");
        } else {
            System.out.println("Failed update property");
        }
        Navigator.back();
    }

    @Override
    public void onInput(int input) {
    }
}
