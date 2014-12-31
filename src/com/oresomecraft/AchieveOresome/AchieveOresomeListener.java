package com.oresomecraft.AchieveOresome;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

/**
 * Created by user on 31/12/2014.
 */
public class AchieveOresomeListener implements Listener {
    private AchieveOresome plugin;



    public AchieveOresomeListener(AchieveOresome plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
}
