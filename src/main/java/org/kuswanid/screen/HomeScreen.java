package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.service.UserService;

public class HomeScreen implements Screen {
    @Override
    public void render() {
        System.out.println("=== Home ===");
        System.out.println("1. Properties");
        System.out.println("2. Customers");
        System.out.println("3. Transactions");
        System.out.println("4. Profile");
        System.out.println("5. Logout");
        System.out.println("0. Exit");
    }

    @Override
    public void onInput(int input) {
        switch (input) {
            case 1: {
                Navigator.go(new PropertiesScreen());
                break;
            }
            case 2: {
                Navigator.go(new CustomersScreen());
                break;
            }
            case 3: {
                Navigator.go(new TransactionsScreen());
                break;
            }
            case 4: {
                Navigator.go(new ProfileScreen());
                break;
            }
            case 5: {
                UserService.getInstance().logout();
                Navigator.replace(new LoginScreen());
                break;
            }
            case 0: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Invalid input");
            }
            ;
        }
    }
}
