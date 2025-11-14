package com.sanyathecreator.shell.command;

import com.sanyathecreator.shell.core.ShellContext;
import com.sanyathecreator.shell.util.InputParser;

public class EchoCommand implements Command {

    @Override
    public void execute(String[] args, ShellContext context) {
        String[] parsedInput = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            parsedInput[i] = InputParser.parseSingleQuotes(args[i]);
        }
        System.out.println(String.join(" ", parsedInput));
    }

}
