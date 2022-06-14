package com.justindimichele.ClapCoords;

import com.justindimichele.ClapCoords.Data.PlaceData;
import com.justindimichele.ClapCoords.Data.PlacesManager;
import com.justindimichele.ClapCoords.Data.ReloadPlacesManager;
import org.bukkit.plugin.java.JavaPlugin;



public class ClapCoords extends JavaPlugin {

    @Override
    public void onEnable()
    {
        System.out.println("ClapCoords has been enabled.");

        // places.yml configuration section. Setup, saving, and loading all available place names.
        PlacesManager.configSetup();
        PlacesManager.get().options().copyDefaults(true);
        PlacesManager.save();
        PlaceData.loadAllPlaceData();

        // Register commands by setting an instance of the command class as an executor.
        this.getCommand("findfriend").setExecutor(new FindFriend(this));
        this.getCommand("findplaces").setExecutor(new FindPlaces(this));
        this.getCommand("saveplace").setExecutor(new SavePlace(this));
        //this.getCommand("removeplace").setExecutor(new RemovePlace(this));

        // Separation for ease of understanding that FindPlace is the only class that uses TabCompleter.
        this.getCommand("findplace").setExecutor(new FindPlace(this));
        this.getCommand("findplace").setTabCompleter(new FindPlace(this));

        // Housekeeping command that allows to reload of the PlacesManager file if there was any manual change to the file.
        this.getCommand("ccreload").setExecutor(new ReloadPlacesManager());
    }

    @Override
    public void onDisable()
    {
        System.out.println("ClapCoords has been disabled.");
    }

}

