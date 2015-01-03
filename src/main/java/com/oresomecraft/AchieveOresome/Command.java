package com.oresomecraft.AchieveOresome;

import java.util.HashMap;

/**
 * Created by azdaspaz818 on 1/01/2015.
 * Base class for commands.
 */
public abstract class Command {
    private static HashMap<String, Class> commandRegistry = new HashMap<String, Class>();

    /**
     * Executes the command
     */
    public abstract void execute(String[] args);

    /**
     * Creates a command object instance
     * @param cmdLabel The name of the command
     * @return The command type specified by the name provided.
     */
    public static Command createCommand(String cmdLabel, Object[] args) {
        try {
            return (Command) commandRegistry.get(cmdLabel).getConstructors()[0].newInstance(args);
        } catch (Exception e) {
            AchieveOresome.getLog().warning("Command Creation Exception: " + e.getMessage());
            return null;
        }
    }

    /**
     *
     */
    public static void registerCommand(String cmdLabel, Class clazz) {
        if(clazz.equals(Achievement.class)) {
            commandRegistry.put(cmdLabel, clazz);
        } else {
            AchieveOresome.getLog().warning("Error registering command '\" + identifier + \".' Not a valid command value.");
        }
    }
}
