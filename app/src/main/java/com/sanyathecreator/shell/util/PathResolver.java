package com.sanyathecreator.shell.util;

import java.io.File;

import com.sanyathecreator.shell.core.ShellContext;

public class PathResolver {

    public static String findExecutableInPath(String command) {
        String pathEnv = ShellContext.PATH;

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
