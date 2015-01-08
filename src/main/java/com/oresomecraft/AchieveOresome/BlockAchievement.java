package com.oresomecraft.AchieveOresome;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;

import java.util.UUID;

public class BlockAchievement extends Achievement {
    private int count;
    private Material material;

    @Override
    public boolean isCompleted(UUID playerID) {
        if (material != null) {
            return (Bukkit.getPlayer(playerID).getStatistic(Statistic.MINE_BLOCK, material) >= count);
        } else {
            return (Bukkit.getPlayer(playerID).getStatistic(Statistic.MINE_BLOCK) >= count);
        }
    }
}
