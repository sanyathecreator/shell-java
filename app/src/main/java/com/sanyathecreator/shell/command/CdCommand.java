package com.sanyathecreator.shell.command;

import java.io.File;

import com.sanyathecreator.shell.core.ShellContext;

public class CdCommand implements Command {

    @Override
    public void execute(String[] args) {
        String path = args[0];
        File directory;

        // Handle tilde(~) for home directory
        path = expandPath(path);

        directory = resolvePath(path);

        // Normalize path for . and .. handling
        try {
            directory = directory.getCanonicalFile();
        } catch (Exception e) {
            printErrorMessage(path);
            return;
        }

        if (!validateDirectory(directory)) {
            printErrorMessage(path);
            return;
        }

        ShellContext.setCurrentDirectory(directory.getAbsolutePath());
    }

    private String expandPath(String path) {
        if (path.equals("~") || path.startsWith("~/")) {
            path = path.replaceFirst("^~", ShellContext.HOME);
        }

        return path;
    }

    private File resolvePath(String path) {
        if (path.startsWith("/")) {
            // Absolute path
            return new File(path);
        }

        // Relative path
        return new File(ShellContext.getCurrentDirectory(), path);
    }

    private boolean validateDirectory(File directory) {
        return !directory.exists() || !directory.isDirectory();
    }

    private void printErrorMessage(String path) {
        System.out.println("cd: " + path + ": No such file or directory");
    }

}
