package com.sanyathecreator.shell.command;

/**
 * Interface for all shell commands (both builtin and external).
 * Implements the Command pattern for extensible command handling.
 */
public interface Command {

    public void execute(String[] args);

}
