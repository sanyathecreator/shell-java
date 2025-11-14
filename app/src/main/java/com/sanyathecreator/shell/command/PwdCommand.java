package com.sanyathecreator.shell.command;

import com.sanyathecreator.shell.core.ShellContext;

public class PwdCommand implements Command {

    @Override
    public void execute(String[] args, ShellContext context) {
        System.out.println(context.getCurrentDirectory());
    }

}
