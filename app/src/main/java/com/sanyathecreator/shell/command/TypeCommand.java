package com.sanyathecreator.shell.command;

import com.sanyathecreator.shell.core.ShellContext;
import com.sanyathecreator.shell.util.PathResolver;

public class TypeCommand implements Command {

    @Override
    public void execute(String[] args, ShellContext context) {
        if (args.length == 0) {
            return;
        }

        String command = args[0];
        if (CommandRegistry.isBuiltin(command)) {
            System.out.println(command + " is a shell builtin");
        } else {
            String commandPath = PathResolver.findExecutableInPath(command, context);
            if (commandPath == null || commandPath.isEmpty()) {
                System.out.println(command + ": not found");
            } else {
                System.out.println(command + " is " + commandPath);
            }
        }
    }

}
