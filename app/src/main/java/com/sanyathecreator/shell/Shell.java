package com.sanyathecreator.shell;

import java.util.Scanner;

import com.sanyathecreator.shell.util.InputParser;

public class Shell {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            String[] parsedInput = InputParser.splitInput(input);

            if (parsedInput.length == 0 || InputParser.getCommand(parsedInput).isEmpty()) {
                continue;
            }

            String command = InputParser.getCommand(parsedInput);
            String[] args = InputParser.getArguments(parsedInput);

            handleExit(command, args);
            handleInvalidCommand(input);
        }
    }

    private void handleExit(String command, String[] args) {
        if (command.equals("exit")) {
            int status = 0;
            System.exit(status);
        }
    }

    private void handleInvalidCommand(String input) {
        System.out.println(input + ": command not found");
    }
}
