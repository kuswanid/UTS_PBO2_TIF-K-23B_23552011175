package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.model.Property;
import org.kuswanid.service.PropertyService;

public class PropertyDetailScreen implements Screen {
    private final PropertyService propertyService = new PropertyService();
    private final String id;

    public PropertyDetailScreen(String id) {
        this.id = id;
    }

    @Override
    public void render() {
        System.out.println("=== Property Detail ===");

        Property property = propertyService.getPropertyDetail(id);

        System.out.println(property.getName());
        System.out.println(property.getType());
        System.out.println(property.getAddress());
        System.out.println(property.getArea());
        System.out.println(property.getPrice());
        if (property.isAvailable()) {
            System.out.println("available");
        } else {
            System.out.println("not available");
        }

        System.out.println();
        System.out.println("1. Edit Property");
        System.out.println("2. Delete Property");
        System.out.println("0. Back");
    }

    @Override
    public void onInput(int input) {
        switch (input) {
            case 1: {
                Navigator.go(new EditPropertyScreen(id));
                break;
            }
            case 2: {
                boolean result = propertyService.deleteProperty(id);
                if (result) {
                    System.out.println("Property deleted");
                } else {
                    System.out.println("Delete property failed");
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
