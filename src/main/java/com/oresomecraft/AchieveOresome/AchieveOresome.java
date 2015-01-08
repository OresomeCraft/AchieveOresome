package com.oresomecraft.AchieveOresome;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Created by azdaspaz818 on 31/12/2014.
 * Main plugin class for AchieveOresome
 */
public class AchieveOresome extends JavaPlugin {
    private static Logger log = Bukkit.getLogger();
    private static Economy econ;

    /**
     * Gets the logger
     *
     * @return The logger to log information from.
     */
    public static Logger getLog() {
        return log;
    }

    @Override
    public void onEnable() {
        AchieveOresome.getLog().info(this.getName() + " version " + this.getDescription().getVersion() + " is now enabled");
        if (!setupEconomy()) {
            AchieveOresome.getLog().warning("[" + this.getName() + "] cannot find the Vault dependency. It will continue to run, but will not award players with monetary rewards.");
        }

        new AchieveOresomeListener(this);
    }

    @Override
    public void onDisable() {
        AchieveOresome.getLog().info(this.getName() + " version " + this.getDescription().getVersion() + " is now disabled");
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null)
            return false;
        econ = rsp.getProvider();
        return (econ != null);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return true;
    }
}
