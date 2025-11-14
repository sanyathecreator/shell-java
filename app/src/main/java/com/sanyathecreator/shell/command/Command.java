package com.sanyathecreator.shell.command;

import com.sanyathecreator.shell.core.ShellContext;

/**
 * Interface for all shell commands (both builtin and external).
 * Implements the Command pattern for extensible command handling.
 */
public interface Command {

    public void execute(String[] args, ShellContext context);

}
