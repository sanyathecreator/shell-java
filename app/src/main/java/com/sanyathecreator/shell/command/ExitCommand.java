package com.sanyathecreator.shell.command;

import com.sanyathecreator.shell.core.ShellContext;

/**
 * Builtin command that exits the shell.
 * Accepts an optional integer exit code (defaults to 0).
 */
public class ExitCommand implements Command {

    @Override
    public void execute(String[] args, ShellContext context) {
        int status = 0;
        if (args.length > 0) {
            try {
                status = Integer.parseInt(args[0]);
            } catch (Exception e) {
                System.err.println("Status code must be integer");
            }
        }
        System.exit(status);
    }

}
