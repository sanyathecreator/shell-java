package com.sanyathecreator.shell;

import java.util.Scanner;

import com.sanyathecreator.shell.command.CommandRegistry;
import com.sanyathecreator.shell.command.ExternalCommand;
import com.sanyathecreator.shell.util.InputParser;
import com.sanyathecreator.shell.util.PathResolver;

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

            if (CommandRegistry.isBuiltin(command)) {
                CommandRegistry.get(command).execute(args);
            } else {
                String commandPath = PathResolver.findExecutableInPath(command);
                if (commandPath != null) {
                    ExternalCommand externalCommand = new ExternalCommand();
                    externalCommand.execute(parsedInput);
                } else {
                    handleInvalidCommand(input);
                }
            }
        }
    }

    private void handleInvalidCommand(String input) {
        System.out.println(input + ": command not found");
    }
}
