package com.sanyathecreator.shell;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sanyathecreator.shell.util.InputParser;

public class InputParserTest {
    @Test
    public void testSingleQuotesParsing() {
        String input = "'helloworld'";
        String expected = "helloworld";
        String actual = InputParser.parseSingleQuotes(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleQuotesWithSpaceParsing() {
        String input = "'hello world'";
        String expected = "hello world";
        String actual = InputParser.parseSingleQuotes(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleQuotesWithSpacesParsing() {
        String input = "'hello   world'";
        String expected = "hello   world";
        String actual = InputParser.parseSingleQuotes(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleQuotesParsingConcatenation() {
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

    @Test
    public void testStringWithoutQuotesParsing() {
        String input = "hello world";
        String expected = "hello world";
        String actual = InputParser.parseSingleQuotes(input);
        assertEquals(expected, actual);
    }
}
