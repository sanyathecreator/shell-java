package com.sanyathecreator.shell.core;

/**
 * Stores shared shell environment context and configuration.
 * Provides access to environment variables and shell state.
 */
public class ShellContext {

    private final String PATH;
    private final String HOME;

    private String currentDirectory;

    public ShellContext() {
        PATH = System.getenv("PATH");
        HOME = System.getenv("HOME");
        currentDirectory = System.getProperty("user.dir");
    }

    public String getPathEnv() {
        return PATH;
    }

    public String getHomeEnv() {
        return HOME;
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(String directory) {
        currentDirectory = directory;
    }

}
