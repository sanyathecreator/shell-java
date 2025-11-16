package com.sanyathecreator.shell.util;

import java.io.File;

import com.sanyathecreator.shell.core.ShellContext;

/**
 * Utility class for resolving executable commands in the system PATH.
 * Searches through PATH directories to locate executable files.
 */
public class PathResolver {

    /**
     * Searches for an executable command in the system PATH.
     *
     * @param command the name of the command to find
     * @param context the shell context containing PATH environment variable
     * @return the absolute path to the executable, or null if not found
     */
    public static String findExecutableInPath(String command, ShellContext context) {
        String pathEnv = context.getPathEnv();

        String[] splitDirs = pathEnv.split(File.pathSeparator);
        for (String dir : splitDirs) {
            File directory = new File(dir);
            if (!directory.exists() || !directory.isDirectory()) {
                continue;
            }

            // Find executable file in directory
            File commandFile = new File(directory, command);
            if (commandFile.exists() && commandFile.canExecute()) {
                return commandFile.getAbsolutePath();
            }
        }

        return null;
    }

}
