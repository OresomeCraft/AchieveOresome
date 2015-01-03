package com.oresomecraft.AchieveOresome;

import org.bukkit.inventory.ItemStack;

import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by azdaspaz818 on 31/12/2014.
 * This class is the base class for all achievements. All achievements must inherit from this class.
 */
public abstract class Achievement {
    private static HashMap<String, Class> achieves = new HashMap<String, Class>();
    private String completionText;
    private int rewardAmount;
    private ArrayList<ItemStack> commonRewards = new ArrayList<ItemStack>();
    private ArrayList<ItemStack> rareRewards = new ArrayList<ItemStack>();

    //region Common Reward Code
    public ArrayList<ItemStack> getCommonDrops() {
        return this.commonRewards;
    }

    public void addCommonReward(ItemStack reward) {
        this.commonRewards.add(reward);
    }

    public void removeCommonReward(ItemStack reward) {
        this.commonRewards.remove(reward);
    }
    //endregion

    public int getRewardAmount() {
        return this.rewardAmount;
    }

    public void setRewardAmount(int amount) {
        this.rewardAmount = amount;
    }

    /**
     * Register a new achievement type in the Achievement Registry
     * @param identifier The identifier used to reference the registered achievement type
     * @param clazz The achievement type to be returned.
     */
    public static void registerAchievement(String identifier, Class clazz) {
        if (clazz.equals(Achievement.class)) {
            achieves.put(identifier, clazz);
        } else {
            AchieveOresome.getLog().warning("Error registering achievement '\" + identifier + \".' Not a valid achievement value.");
        }
    }

    /**
     * Returns the requested Achievement.
     * @param identifier The identifier used to reference the registered achievement type.
     * @param args The args used to initiate the Achievement
     * @return The achievement object.
     */
    public static Achievement createAchievement(String identifier, Object[] args) {
        try {
            return (Achievement) achieves.get(identifier).getConstructors()[0].newInstance(args);
        } catch (Exception e) {
            AchieveOresome.getLog().warning("Achievement Creation Exception: " + e.getMessage());
            return null;
        }
    }

    /**
     * Sets the completion text for this instance.
     * @param text New completion text.
     */
    public void setCompletionText(String text) {
        this.completionText = text;
    }

    /**
     * Gets the completion text for this instance.
     * @return The completion text.
     */
    public String getCompletionText() {
        return this.completionText;
    }
}
