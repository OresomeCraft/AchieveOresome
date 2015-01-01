package com.oresomecraft.AchieveOresome;

import java.util.HashMap;

/**
 * Created by azdaspaz818 on 1/01/2015.
 * Base class for commands.
 */
public abstract class Command {
    private static HashMap<String, Command> commandRegistry = new HashMap<String, Command>();

    /**
     * Creates a command object instance
     * @param cmd The name of the command
     * @return The command type specified by the name provided.
     */
    public static Command createCommand(String cmd) {
        return null;
    }
}
