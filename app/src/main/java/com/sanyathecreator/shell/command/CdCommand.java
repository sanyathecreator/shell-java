package com.sanyathecreator.shell.command;

import java.io.File;

import com.sanyathecreator.shell.core.ShellContext;

/**
 * Builtin command that changes the current working directory.
 * Supports absolute paths, relative paths, and tilde expansion for home directory.
 */
public class CdCommand implements Command {

    @Override
    public void execute(String[] args, ShellContext context) {
        String path = args[0];
        File directory;

        // Handle tilde(~) for home directory
        path = expandPath(path, context);

        directory = resolvePath(path, context);

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

        context.setCurrentDirectory(directory.getAbsolutePath());
    }

    private String expandPath(String path, ShellContext context) {
        if (path.equals("~") || path.startsWith("~/")) {
            path = path.replaceFirst("^~", context.getHomeEnv());
        }

        return path;
    }

    private File resolvePath(String path, ShellContext context) {
        if (path.startsWith("/")) {
            // Absolute path
            return new File(path);
        }

        // Relative path
        return new File(context.getCurrentDirectory(), path);
    }

    private boolean validateDirectory(File directory) {
        return directory.exists() && directory.isDirectory();
    }

    private void printErrorMessage(String path) {
        System.out.println("cd: " + path + ": No such file or directory");
    }

}
