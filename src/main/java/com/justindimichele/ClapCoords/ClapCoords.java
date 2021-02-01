package com.justindimichele.ClapCoords;


import com.justindimichele.ClapCoords.Data.PlacesManager;
import com.justindimichele.ClapCoords.Data.ReloadPlacesManager;
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
        Create compass object -- research
    */

    //public static PlacesManager places;

    @Override
    public void onEnable()
    {
        System.out.println("ClapCoords has been enabled.");

        PlacesManager.configSetup();
        PlacesManager.get().options().copyDefaults(true);
        PlacesManager.save();

        System.out.println("ClapCoords has been enabled!");


        //Registering the command needs to be done within the onEnable class.
        //Register commands by setting an instance of the command class as an executor.
        this.getCommand("findfriend").setExecutor(new FindFriend(this));
        this.getCommand("saveplace").setExecutor(new SavePlace(this));
        this.getCommand("findplaces").setExecutor(new FindPlaces(this));

        this.getCommand("ccreload").setExecutor(new ReloadPlacesManager());
    }

    @Override
    public void onDisable()
    {
        System.out.println("ClapCoords has been disabled.");
    }

}

