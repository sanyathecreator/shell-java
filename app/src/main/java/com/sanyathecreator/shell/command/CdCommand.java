package com.sanyathecreator.shell.command;

import java.io.File;

import com.sanyathecreator.shell.core.ShellContext;

public class CdCommand implements Command {

    @Override
    public void execute(String[] args) {
        String path = args[0];
        File directory = new File(path);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("cd: " + path + ": No such file or directory");
            return;
        }

        ShellContext.setCurrentDirectory(path);
    }

}
