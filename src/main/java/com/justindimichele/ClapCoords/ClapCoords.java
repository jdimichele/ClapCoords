package com.justindimichele.ClapCoords;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ClapCoords extends JavaPlugin {

    /*
        TODO:
        Add saving places command with naming argument and saving players name -- /saveplace <name of place>
        Add un-saving places command with naming argument allowing ONLY that player can unsave -- /unsaveplace <name of place>
        Specify permission to unsave places -- Do research
        List all places command -- /places
        List player made specific locations -- /list
        List all players positions -- /findfriends
    */


    @Override
    public void onEnable()
    {
        System.out.println("ClapCoords has been enabled.");

        //Registering the command needs to be done within the onEnable class.
        //Register commands by setting an instance of the command class as an executor.
        this.getCommand("findfriend").setExecutor(new FindFriend(this));
    }

    @Override
    public void onDisable()
    {
        System.out.println("ClapCoords has been disabled.");
    }
}

