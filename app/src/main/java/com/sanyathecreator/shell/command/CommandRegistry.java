package com.sanyathecreator.shell.command;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private static final Map<String, Command> commands = new HashMap<>();

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
