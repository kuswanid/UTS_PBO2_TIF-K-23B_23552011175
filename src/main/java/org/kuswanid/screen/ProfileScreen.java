package org.kuswanid.screen;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.model.User;
import org.kuswanid.service.UserService;

public class ProfileScreen implements Screen {
    private final UserService userService = UserService.getInstance();

    @Override
    public void render() {
        System.out.println("=== Profile ===");

        User user = userService.getCurrentUser();

        System.out.println(user.getName());
        System.out.println(user.getEmail());

        System.out.println();
        System.out.println("0. Back");
    }

    @Override
    public void onInput(int input) {
        switch (input) {
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
