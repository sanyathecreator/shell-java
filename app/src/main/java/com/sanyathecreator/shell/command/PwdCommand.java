package com.sanyathecreator.shell.command;

import com.sanyathecreator.shell.core.ShellContext;

public class PwdCommand implements Command {

    @Override
    public void execute(String[] args) {
        System.out.println(ShellContext.getCurrentDirectory());
    }

}
