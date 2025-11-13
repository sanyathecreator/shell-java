package com.sanyathecreator.shell.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import com.sanyathecreator.shell.core.ShellContext;

public class ExternalCommand implements Command {

    @Override
    public void execute(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder(args);
        // Set working directory for external process
        processBuilder.directory(new File(ShellContext.getCurrentDirectory()));

        try {
            Process process = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {

                String line;
                // Read output stream
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                // Read error stream
                while ((line = errorReader.readLine()) != null) {
                    System.err.println(line);
                }

                process.waitFor();
            }
        } catch (Exception e) {
            System.err.println("Error executing command: " + e.getMessage());
        }
    }

}
