package com.oresomecraft.AchieveOresome;

import java.util.HashMap;

/**
 * Created by azdaspaz818 on 31/12/2014.
 * This class is the base class for all achievements. All achievements must inherit from this class.
 */
public abstract class Achievement {
    private static HashMap<String, Class> achievements = new HashMap<String, Class>();
    private String completionText;

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
}
