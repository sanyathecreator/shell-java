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

    public static String parseSingleQuotes(String input) {
        int start = 0;
        int end = 0;
        String result = "";
        boolean insideQuotes = false;

        for (int i = 0; i < input.length(); i++) {
            if (!insideQuotes && i == input.length() - 1) {
                result = result + input.substring(start);
            }
            if (input.charAt(i) == '\'' && !insideQuotes) {
                if (input.charAt(i + 1) == '\'') {
                    end = i;
                    i++;
                    result = result + input.substring(start, end);
                    start = i + 1;
                } else {
                    // Skip
                    i++;
                    start = i;
                    insideQuotes = true;
                }
            } else if (input.charAt(i) == '\'' && insideQuotes) {
                if (i != input.length() - 1) {
                    if (input.charAt(i + 1) == '\'') {
                        end = i;
                        insideQuotes = false;
                    }
                }
                end = i;
                result = result + input.substring(start, end);
            }
        }

        return result;
    }

}
