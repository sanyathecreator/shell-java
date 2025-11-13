package com.sanyathecreator.shell.command;

import java.io.File;

import com.sanyathecreator.shell.core.ShellContext;

public class CdCommand implements Command {

    @Override
    public void execute(String[] args) {
        String path = args[0];
        File directory;

        // Handle tilder(~) for home directory
        if (path.equals("~") || path.startsWith("~/")) {
            path = path.replaceFirst("^~", ShellContext.HOME);
        }

        if (path.startsWith("/")) {
            // Absolute path
            directory = new File(path);
        } else {
            // Relative path
            directory = new File(ShellContext.getCurrentDirectory(), path);
        }

        // Normalize path for . and .. handling
        try {
            directory = directory.getCanonicalFile();
        } catch (Exception e) {
            System.out.println("cd: " + path + ": No such file or directory");
            return;
        }

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("cd: " + path + ": No such file or directory");
            return;
        }

        ShellContext.setCurrentDirectory(directory.getAbsolutePath());
    }

}
