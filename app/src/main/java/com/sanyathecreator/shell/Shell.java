package com.sanyathecreator.shell;

import java.util.Scanner;

public class Shell {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            handleInvalidCommand(input);
        }
    }

    private void handleInvalidCommand(String input) {
        System.out.println(input + ": command not found");
    }
}
