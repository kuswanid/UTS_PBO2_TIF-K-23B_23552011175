package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.service.UserService;

import java.util.Scanner;

public class LoginScreen implements Screen {
    private final UserService userService = UserService.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void render() {
        System.out.println("=== Login ===");

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean result = userService.login(email, password);
        if (result) {
            Navigator.replace(new HomeScreen());
        } else {
            System.out.println("Login failed");
            Navigator.refresh();
        }
    }

    @Override
    public void onInput(int input) {
    }
}
