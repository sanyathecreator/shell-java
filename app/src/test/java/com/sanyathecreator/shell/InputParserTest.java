package com.sanyathecreator.shell;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sanyathecreator.shell.util.InputParser;

public class InputParserTest {
    @Test
    public void testSingleQuotesPasring() {
        String input = "'helloworld'";
        String expected = "helloworld";
        String actual = InputParser.parseSingleQuotes(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleQuotesWithSpacePasring() {
        String input = "'hello world'";
        String expected = "hello world";
        String actual = InputParser.parseSingleQuotes(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleQuotesWithSpacesPasring() {
        String input = "'hello   world'";
        String expected = "hello   world";
        String actual = InputParser.parseSingleQuotes(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleQuotesPasringConcatenation() {
        String input = "'hello''world'";
        String expected = "helloworld";
        String actual = InputParser.parseSingleQuotes(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleQuotesIgnoringParsing() {
        String input = "hello''world";
        String expected = "helloworld";
        String actual = InputParser.parseSingleQuotes(input);
        assertEquals(expected, actual);
    }
}
