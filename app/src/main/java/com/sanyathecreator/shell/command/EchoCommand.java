package com.sanyathecreator.shell.command;

import com.sanyathecreator.shell.core.ShellContext;

public class EchoCommand implements Command {

    @Override
    public void execute(String[] args, ShellContext context) {
        System.out.println(String.join(" ", args));
    }

}
