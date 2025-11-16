package com.sanyathecreator.shell;

import com.sanyathecreator.shell.core.Shell;

/**
 * Entry point for the shell application.
 * Initializes and starts the shell REPL.
 */
public class Main {
    public static void main(String[] args) {
        Shell shell = new Shell();
        shell.start();
    }
}
