package com.oresomecraft.AchieveOresome;

import org.bukkit.command.CommandSender;

/**
 * Created by user on 1/01/2015.
 */
public class CommandExecutor {
    public boolean execute(String cmd, CommandSender sender, String label, String[] args) {
        Command command = Command.createCommand(cmd);
        if (command == null) {
            return false;
        } else {
            return true;
        }
    }
}
