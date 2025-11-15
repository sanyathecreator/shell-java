package com.sanyathecreator.shell.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import com.sanyathecreator.shell.core.ShellContext;

public class ExternalCommand implements Command {

    @Override
    public void execute(String[] args, ShellContext context) {
        ProcessBuilder processBuilder = new ProcessBuilder(args);
        // Set working directory for external process
        processBuilder.directory(new File(context.getCurrentDirectory()));
        // Merge stderr and stdout to prevent deadlock
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {

                String line;
                // Read output stream
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                process.waitFor();
            }
        } catch (Exception e) {
            System.err.println("Error executing command: " + e.getMessage());
        }
    }

}
