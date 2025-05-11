package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.model.Property;
import org.kuswanid.service.PropertyService;

import java.util.List;

public class PropertiesScreen implements Screen {
    private final PropertyService propertyService = new PropertyService();
    private List<Property> properties;

    @Override
    public void render() {
        System.out.println("=== Properties ===");

        properties  = propertyService.getAllProperties();

        if (properties.isEmpty()) {
            System.out.println("No properties data");
            System.out.println();
        }
        for (int i = 0; i < properties.size(); i++) {
            System.out.println(i + 1 + ". " + properties.get(i).getName());
            System.out.println("   " + properties.get(i).getType());
            System.out.println("   " + properties.get(i).getAddress());
            System.out.println("   Rp" + properties.get(i).getPrice());
            System.out.println();
        }

        System.out.println(properties.size() + 1 + ". Add New Property");
        System.out.println("0. Back");
    }

    @Override
    public void onInput(int input) {
        if (input > 0 && input <= properties.size()) {
            String id = properties.get(input - 1).getId();
            Navigator.go(new PropertyDetailScreen(id));
        } else if (input == properties.size() + 1) {
            Navigator.go(new AddPropertyScreen());
        } else if (input == 0) {
            Navigator.back();
        } else {
            System.out.println("Invalid input");
        }
    }
}
