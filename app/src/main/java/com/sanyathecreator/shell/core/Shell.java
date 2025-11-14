package com.sanyathecreator.shell.core;

import java.util.Scanner;

import com.sanyathecreator.shell.command.CommandRegistry;
import com.sanyathecreator.shell.command.ExternalCommand;
import com.sanyathecreator.shell.util.InputParser;
import com.sanyathecreator.shell.util.PathResolver;

/**
 * Main shell class that handles the read-eval-print loop (REPL).
 * Reads user input, parses commands, and dispatches them to either
 * builtin commands or external executables.
 */
public class Shell {
    private ShellContext shellContext;

    public Shell() {
        shellContext = new ShellContext();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            String[] parsedInput = InputParser.splitInput(input);

            // Skip empty input
            if (parsedInput.length == 0 || InputParser.getCommand(parsedInput).isEmpty()) {
                continue;
            }

            String command = InputParser.getCommand(parsedInput);
            String[] arguments = InputParser.getArguments(parsedInput);
            String[] args = InputParser.parseSingleQuotes(String.join(" ", arguments));

            if (CommandRegistry.isBuiltin(command)) {
                CommandRegistry.get(command).execute(args, shellContext);
            } else {
                if (PathResolver.findExecutableInPath(command, shellContext) != null) {
                    ExternalCommand externalCommand = new ExternalCommand();
                    externalCommand.execute(parsedInput, shellContext);
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
