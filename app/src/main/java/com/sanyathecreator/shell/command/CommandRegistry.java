package com.sanyathecreator.shell.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry that stores and manages all builtin shell commands.
 * Uses a map to associate command names with their implementations.
 */
public class CommandRegistry {
    private static final Map<String, Command> commands = new HashMap<>();

    // Register all builtin commands
    static {
        commands.put("exit", new ExitCommand());
        commands.put("echo", new EchoCommand());
        commands.put("type", new TypeCommand());
    }

    public static Command get(String name) {
        return commands.get(name);
    }

    public static boolean isBuiltin(String name) {
        return commands.containsKey(name);
    }
}
