package com.oresomecraft.AchieveOresome;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by azdaspaz818 on 3/01/2015.
 */
public class LocationAchievement extends Achievement {
    private Location loc;
    private int radius;

    @Override
    public boolean isCompleted(UUID playerID) {
        Player p = Bukkit.getPlayer(playerID);
        return this.loc.distance(p.getLocation()) <= this.radius;
    }
}
