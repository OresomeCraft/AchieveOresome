package com.oresomecraft.AchieveOresome;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * Created by ScruffyRules on 9/01/2015.
 */
public class KillAchievement extends Achievement {
    private int count;
    private EntityType entityType;

    @Override
    public boolean isCompleted(UUID playerID) {
        if (entityType != null) {
            return (Bukkit.getPlayer(playerID).getStatistic(Statistic.MOB_KILLS, entityType) >= count);
        } else {
            return (Bukkit.getPlayer(playerID).getStatistic(Statistic.MOB_KILLS) >= count);
        }
    }
}
