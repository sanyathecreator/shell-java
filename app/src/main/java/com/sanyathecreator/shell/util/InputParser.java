package com.sanyathecreator.shell.util;

/**
 * Utility class for parsing user input into commands and arguments.
 * Provides methods to split input and extract command components.
 */
public class InputParser {
    private static final String DELIMITER = " ";
    private static final int COMMAND_INDEX = 0;

    public static String[] splitInput(String input) {
        return input.split(DELIMITER);
    }

    public static String getCommand(String[] splitInput) {
        return splitInput[COMMAND_INDEX];
    }

    public static String[] getArguments(String[] input) {
        String[] arguments = new String[input.length - 1];
        System.arraycopy(input, 1, arguments, 0, input.length - 1);
        return arguments;
    }

}
