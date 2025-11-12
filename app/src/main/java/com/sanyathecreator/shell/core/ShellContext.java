package com.sanyathecreator.shell.core;

/**
 * Stores shared shell environment context and configuration.
 * Provides access to environment variables and shell state.
 */
public class ShellContext {

    public static final String PATH = System.getenv("PATH");
    public static String currentDirectory = System.getProperty("user.dir");

}
