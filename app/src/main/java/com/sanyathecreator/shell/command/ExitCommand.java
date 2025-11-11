package com.sanyathecreator.shell.command;

public class ExitCommand implements Command {

    public void execute(String[] args) {
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
