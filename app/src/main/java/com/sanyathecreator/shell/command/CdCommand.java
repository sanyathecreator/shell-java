package com.sanyathecreator.shell.command;

import java.io.File;

import com.sanyathecreator.shell.core.ShellContext;

public class CdCommand implements Command {

    @Override
    public void execute(String[] args) {
        String path = args[0];
        File directory;

        if (path.startsWith("/")) {
            // Absolute path
            directory = new File(path);
        } else {
            // Relative path
            directory = new File(ShellContext.getCurrentDirectory(), path);
        }

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("cd: " + path + ": No such file or directory");
            return;
        }

        ShellContext.setCurrentDirectory(directory.getAbsolutePath());
    }

}
