package com.sanyathecreator.shell.command;

public class TypeCommand implements Command {

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            return;
        }

        String command = args[0];
        if (CommandRegistry.isBuiltin(command)) {
            System.out.println(command + " is a shell builtin");
        } else {
            System.out.println(command + ": not found");
        }
    }

}
