package com.sanyathecreator.shell.command;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private static final Map<String, Command> commands = new HashMap<>();

    public CommandRegistry() {
        commands.put("exit", new ExitCommand());
    }

    public Command get(String name) {
        return commands.get(name);
    }

    public boolean isBuiltin(String name) {
        return commands.containsKey(name);
    }
}
