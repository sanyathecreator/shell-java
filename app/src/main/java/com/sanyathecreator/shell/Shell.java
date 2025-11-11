package com.sanyathecreator.shell;

import java.util.Scanner;

public class Shell {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            String[] parts = splitInput(input);
            exit(parts);
            handleInvalidCommand(input);
        }
    }

    private String[] splitInput(String input) {
        return input.split(" ");
    }

    private void exit(String[] input) {
        if (input[0].equals("exit")) {
            int status = 0;
            System.exit(status);
        }
    }

    private void handleInvalidCommand(String input) {
        System.out.println(input + ": command not found");
    }
}
