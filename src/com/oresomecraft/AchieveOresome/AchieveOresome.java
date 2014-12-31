package com.oresomecraft.AchieveOresome;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Created by azdaspaz818 on 31/12/2014.
 * Main plugin class for AchieveOresome
 */
public class AchieveOresome extends JavaPlugin {
    private static Logger log = Logger.getLogger("Minecraft");

    /**
     * Gets the logger
     * @return The logger to log information from.
     */
    public static Logger getLog() {
        return log;
    }

    @Override
    public void onEnable() {
        new AchieveOresomeListener(this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return true;
    }
}
