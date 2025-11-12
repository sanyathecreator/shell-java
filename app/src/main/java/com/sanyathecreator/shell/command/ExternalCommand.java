package com.sanyathecreator.shell.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import com.sanyathecreator.shell.core.ShellContext;

public class ExternalCommand implements Command {

    @Override
    public void execute(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(args);

            // Set working directory for the external process
            processBuilder.directory(new File(ShellContext.currentDirectory));
            Process process = processBuilder.start();

            // Read output stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Read error stream
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            process.waitFor();
        } catch (Exception e) {
            System.err.println("Error executing command: " + e.getMessage());
        }
    }

}
