package com.oresomecraft.AchieveOresome;

import java.lang.reflect.InvocationTargetException;
import java.rmi.activation.Activator;
import java.util.HashMap;

/**
 * Created by azdaspaz818 on 31/12/2014.
 * This class is the base class for all achievements. All achievements must inherit from this class.
 */
public abstract class Achievement {
    private static HashMap<String, Achievement> achieves = new HashMap<String, Achievement>();

    /**
     * Register a new achievement type in the Achievement Registry
     * @param identifier The identifier used to reference the registered achievement type
     * @param achieve The achievement type to be returned.
     */
    public void registerAchievement(String identifier, Achievement achieve) {
        achieves.put(identifier, achieve);
    }

    /**
     * Returns the requested Achievement.
     * @param identifier The identifier used to reference the registered achievement type.
     * @param args The args used to initiate the Achievement
     * @return The achievement object.
     */
    public Achievement createAchievement(String identifier, Object[] args) {
        try {
            return (Achievement) achieves.get(identifier).getClass().getConstructors()[0].newInstance(args);
        } catch (Exception e) {
            AchieveOresome.getLog().warning("Achievement Creation Exception: " + e.getMessage());
            return null;
        }
    }
}
