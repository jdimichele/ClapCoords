package com.justindimichele.ClapCoords;

import com.justindimichele.ClapCoords.Data.PlaceData;
import com.justindimichele.ClapCoords.Data.PlacesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindPlaces implements CommandExecutor {
    ClapCoords plugin;
    public FindPlaces(ClapCoords plugin) {this.plugin = plugin;}

    /**
     * FindPlaces class will display a list of all places that have been saved in the world.
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("findplaces") || command.getName().equalsIgnoreCase(label)){
            Player player = (Player) sender;

            List<PlaceData> allPlaceNames = PlaceData.getAllPlaceData();
            for (PlaceData place : allPlaceNames){
                  player.sendMessage(place.placeName + " is at: " + place.placeLoc + ", " + place.dimension + ".");
                }
            }
           return true;
        }
    }
