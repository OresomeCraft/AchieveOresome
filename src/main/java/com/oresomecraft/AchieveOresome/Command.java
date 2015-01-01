package com.oresomecraft.AchieveOresome;

import java.util.HashMap;

/**
 * Created by user on 1/01/2015.
 */
public abstract class Command {
    private static HashMap<String, Command> commandRegistry = new HashMap<String, Command>();

    public static Command createCommand(String cmd) {
        return null;
    }
}
