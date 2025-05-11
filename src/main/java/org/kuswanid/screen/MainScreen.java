package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;

public class MainScreen implements Screen {
    @Override
    public void render() {
        System.out.println("=== PropertEase ===");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");
    }

    @Override
    public void onInput(int input) {
        switch (input) {
            case 1: {
                Navigator.go(new LoginScreen());
                break;
            }
            case 2: {
                Navigator.go(new RegisterScreen());
                break;
            }
            case 0: {
                System.exit(0);
            }
            default: {
                System.out.println("Invalid input");
            }
        }
    }
}
