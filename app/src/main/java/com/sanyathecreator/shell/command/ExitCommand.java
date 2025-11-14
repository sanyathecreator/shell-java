package com.sanyathecreator.shell.command;

import com.sanyathecreator.shell.core.ShellContext;

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
