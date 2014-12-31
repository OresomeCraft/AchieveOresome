package com.oresomecraft.AchieveOresome;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

/**
 * Created by azdaspaz818 on 31/12/2014.
 * Listener for Minecraft events.
 */
public class AchieveOresomeListener implements Listener {
    private AchieveOresome plugin;


    /**
     * Base constructor for creating an AchieveOresome listener
     * @param plugin The AchieveOresome plugin to listen to.
     */
    public AchieveOresomeListener(AchieveOresome plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
}
