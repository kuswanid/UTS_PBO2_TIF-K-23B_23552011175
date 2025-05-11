package org.kuswanid.lib;

import java.util.Stack;

public class Navigator {
    private static final Stack<Screen> history = new Stack<>();

    public static Screen getCurrentScreen() {
        return history.peek();
    }

    public static void back() {
        if (!history.isEmpty()) {
            history.pop();
            if (!history.isEmpty()) {
                System.out.println();
                history.peek().render();
            }
        }
    }

    public static void go(Screen destination) {
        history.push(destination);
        System.out.println();
        destination.render();
    }

   public static void refresh() {
        if (!history.isEmpty()) {
            System.out.println();
            history.peek().render();
        }
   }

    public static void replace(Screen destination) {
        if (!history.isEmpty()) {
            history.pop();
        }
        history.push(destination);
        System.out.println();
        destination.render();
    }
}
