package org.kuswanid;

import org.kuswanid.lib.Navigator;
import org.kuswanid.lib.Screen;
import org.kuswanid.screen.MainScreen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Navigator.go(new MainScreen());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.print("▶ Input: ");
            int input = scanner.nextInt();
            Screen currentScreen = Navigator.getCurrentScreen();

            currentScreen.onInput(input);
        }
    }
}