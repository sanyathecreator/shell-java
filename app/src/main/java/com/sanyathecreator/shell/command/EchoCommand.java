package com.sanyathecreator.shell.command;

import com.sanyathecreator.shell.core.ShellContext;

/**
 * Builtin command that prints arguments to standard output.
 * Joins all arguments with spaces and outputs them.
 */
public class EchoCommand implements Command {

    @Override
    public void execute(String[] args, ShellContext context) {
        System.out.println(String.join(" ", args));
    }

}
