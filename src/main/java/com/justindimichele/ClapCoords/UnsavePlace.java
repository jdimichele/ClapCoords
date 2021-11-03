package com.justindimichele.ClapCoords;

import com.justindimichele.ClapCoords.Data.PlaceData;
import com.justindimichele.ClapCoords.Data.PlacesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnsavePlace implements CommandExecutor {
    ClapCoords plugin;
    public UnsavePlace (ClapCoords plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("unsave") || command.getName().equalsIgnoreCase(label)){
            Player player = (Player) sender;

            String placeName = "";
            for (int i = 0; i < args.length; i++) {
                placeName += args[i] + " ";
            }
            placeName = placeName.trim();
            String placeKey = placeName.toLowerCase();
            String dimension = player.getWorld().getEnvironment().toString().toLowerCase();


            Map<String, Object> places = PlacesManager.get().getConfigurationSection("Places").getValues(false);
            MemorySection placeInfoObject = (MemorySection) places.get(placeKey);

            Map<String, Object> placeInfo = (placeInfoObject.getValues(false));

            if(placeInfo.containsKey(placeName)){
                places.replace(placeKey, placeName, null);

                PlacesManager.save();
                PlacesManager.reload();
                player.sendMessage("You unsaved " + placeName + ", " + dimension);
            } else {
                player.sendMessage("This place does not exist!");
            }
        }
        return false;
    }

}
