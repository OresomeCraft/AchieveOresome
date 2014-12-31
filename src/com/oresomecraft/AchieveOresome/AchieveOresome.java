package com.oresomecraft.AchieveOresome;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by user on 31/12/2014.
 */
public class AchieveOresome extends JavaPlugin {


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
