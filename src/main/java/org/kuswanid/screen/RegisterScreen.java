package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.service.UserService;

import java.util.Scanner;

public class RegisterScreen implements Screen {
    private final UserService userService = UserService.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void render() {
        System.out.println("=== Register ===");

        System.out.print("Name     : ");
        String name = scanner.nextLine();

        System.out.print("Email    : ");
        String email = scanner.nextLine();

        System.out.print("Password : ");
        String password = scanner.nextLine();

        boolean result = userService.register(email, name, password);
        if (result) {
            Navigator.replace(new LoginScreen());
        } else {
            System.out.println("Register failed");
            Navigator.refresh();
        }
    }

    @Override
    public void onInput(int input) {
    }
}
