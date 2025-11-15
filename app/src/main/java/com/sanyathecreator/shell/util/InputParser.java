package com.sanyathecreator.shell.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for parsing user input into commands and arguments.
 * Provides methods to split input and extract command components.
 */
public class InputParser {
    private static final String DELIMITER = " ";
    private static final int COMMAND_INDEX = 0;
    private static final int ARGUMENTS_INDEX = 1;

    public static String[] splitInput(String input) {
        return input.split(DELIMITER, 2);
    }

    public static String getCommand(String[] splitInput) {
        return splitInput[COMMAND_INDEX];
    }

    public static String getArguments(String[] splitInput) {
        if (splitInput.length > 1) {
            return splitInput[ARGUMENTS_INDEX];
        }
        return null;
    }

    public static String[] parseSingleQuotes(String input) {
        boolean insideSingleQuotes = false;
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (character == '\'') {
                insideSingleQuotes = !insideSingleQuotes;
                // Skip space if outside single quotes
            } else if (character == ' ' && !insideSingleQuotes) {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken = new StringBuilder();
                }
            } else {
                currentToken.append(character);
            }
        }

        // Add last token
        if (!currentToken.isEmpty()) {
            tokens.add(currentToken.toString());
        }

        return tokens.toArray(new String[0]);
    }

}
