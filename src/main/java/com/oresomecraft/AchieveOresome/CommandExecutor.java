package com.oresomecraft.AchieveOresome;

import org.bukkit.command.CommandSender;

/**
 * Created by azdaspaz818 on 1/01/2015.
 * This class takes a command and executes it.
 */
public class CommandExecutor {
    /**
     * Execute the given command.
     *
     * @param cmd    The Command to execute
     * @param sender The sender of the command
     * @param label  The label of the command
     * @param args   The arguments to execute the command with.
     * @return True if the command executes correctly, otherwise false.
     */
    public boolean execute(String cmd, CommandSender sender, String label, String[] args) {
        Command command = Command.createCommand(cmd, args);
        if (command != null) {
            command.execute(args);
            return true;
        } else {
            return false;
        }
    }

    public boolean execute(String cmd, CommandSender sender, String label) {
        return execute(cmd, sender, label, new String[]{});
    }
}
