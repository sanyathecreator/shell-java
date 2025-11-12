package com.sanyathecreator.shell;

import java.util.Scanner;

import com.sanyathecreator.shell.command.CommandRegistry;
import com.sanyathecreator.shell.util.InputParser;

public class Shell {
    private CommandRegistry commandRegistry;

    public Shell() {
        commandRegistry = new CommandRegistry();
    }

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

            if (CommandRegistry.isBuiltin(command)) {
                commandRegistry.get(command).execute(args);
            } else {
                handleInvalidCommand(input);
            }
        }
    }

    private void handleInvalidCommand(String input) {
        System.out.println(input + ": command not found");
    }
}
