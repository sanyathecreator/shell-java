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

    /**
     * Splits user input into command and arguments parts.
     *
     * @param input the raw user input string
     * @return array where [0] is the command and [1] is the arguments (if any)
     */
    public static String[] splitInput(String input) {
        return input.split(DELIMITER, 2);
    }

    /**
     * Extracts the command name from split input.
     *
     * @param splitInput the input array from splitInput()
     * @return the command name
     */
    public static String getCommand(String[] splitInput) {
        return splitInput[COMMAND_INDEX];
    }

    /**
     * Extracts the arguments from split input.
     *
     * @param splitInput the input array from splitInput()
     * @return the arguments string, or null if no arguments
     */
    public static String getArguments(String[] splitInput) {
        if (splitInput.length > 1) {
            return splitInput[ARGUMENTS_INDEX];
        }
        return null;
    }

    /**
     * Parses a string containing single-quoted tokens.
     * Handles quoted strings and preserves spaces within quotes.
     * Multiple spaces between tokens are collapsed into single spaces.
     *
     * @param input the string to parse
     * @return array of parsed tokens with quotes removed
     */
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
                // Keep only one space between tokens
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
