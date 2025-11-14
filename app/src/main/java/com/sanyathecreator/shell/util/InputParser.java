package com.sanyathecreator.shell.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public static String[] parseSingleQuotes(String input) {
        boolean isInsideSingleQuotes = false;
        List<String> keywords = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (character == '\'') {
                isInsideSingleQuotes = !isInsideSingleQuotes;
            } else if (character == ' ' && !isInsideSingleQuotes) {
                if (builder.length() > 0) {
                    keywords.add(builder.toString());
                    builder = new StringBuilder();
                }
            } else {
                builder.append(character);
            }
        }

        // Add last token
        if (!builder.isEmpty()) {
            keywords.add(builder.toString());
        }

        return keywords.toArray(new String[0]);
    }

}
