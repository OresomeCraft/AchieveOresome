package com.oresomecraft.AchieveOresome;

import org.bukkit.inventory.ItemStack;

import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by azdaspaz818 on 31/12/2014.
 * This class is the base class for all achievements. All achievements must inherit from this class.
 */
public abstract class Achievement {
    private static HashMap<String, Class> achievements = new HashMap<String, Class>();
    private String completionText;
    private String name;
    private String description;
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

    //region Rare Reward Code
    public ArrayList<ItemStack> getRareRewards() {
        return this.rareRewards;
    }

    public void addRareReward(ItemStack reward) {
        this.commonRewards.add(reward);
    }

    public void removeRareReward(ItemStack reward) {
        this.commonRewards.remove(reward);
    }
    //endregion

    //region Reward Amount
    public int getRewardAmount() {
        return this.rewardAmount;
    }

    public void setRewardAmount(int amount) {
        this.rewardAmount = amount;
    }
    //endregion

    //region General Information
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    //endregion

    /**
     * Register a new achievement type in the Achievement Registry
     *
     * @param identifier The identifier used to reference the registered achievement type
     * @param clazz      The achievement type to be returned.
     */
    public static void registerAchievement(String identifier, Class clazz) {
        if (clazz.equals(Achievement.class)) {
            achievements.put(identifier, clazz);
        } else {
            AchieveOresome.getLog().warning("Error registering achievement \'" + identifier + "\'. Not a valid achievement value.");
        }
    }

    /**
     * Returns the requested Achievement.
     *
     * @param identifier The identifier used to reference the registered achievement type.
     * @param args       The args used to initiate the Achievement
     * @return The achievement object.
     */
    public static Achievement createAchievement(String identifier, Object[] args) {
        try {
            return (Achievement) achievements.get(identifier).getConstructors()[0].newInstance(args);
        } catch (Exception ex) {
            AchieveOresome.getLog().warning("Achievement Creation Exception: " + ex.getMessage());
        }
        return null;
    }

    /**
     * Sets the completion text for this instance.
     *
     * @param text New completion text.
     */
    public void setCompletionText(String text) {
        this.completionText = text;
    }

    /**
     * Gets the completion text for this instance.
     *
     * @return The completion text.
     */
    public String getCompletionText() {
        return this.completionText;
    }

    //Completion Check
    public abstract boolean isCompleted(UUID playerID);

    //Complete the achievement - sets this achievement to completed for the specified player; gives reward.
    public void awardTo(UUID playerID) {

    }
}
