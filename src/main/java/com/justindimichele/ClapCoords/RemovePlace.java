package com.justindimichele.ClapCoords;

import com.justindimichele.ClapCoords.Data.PlaceData;
import com.justindimichele.ClapCoords.Data.PlacesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;

public class RemovePlace implements CommandExecutor {
    ClapCoords plugin;
    public RemovePlace (ClapCoords plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("remove") || command.getName().equalsIgnoreCase(label)){
            Player player = (Player) sender;

            String placeName = "";
            for (int i = 0; i < args.length; i++) {
                placeName += args[i] + " ";
            }
            placeName = placeName.trim();
            String placeKey = placeName.toLowerCase();
            String dimension = player.getWorld().getEnvironment().toString().toLowerCase();

            Map<String, Object> places =
                    PlacesManager.get().getConfigurationSection("Places").getValues(false);

            if(!places.containsKey(placeName)){
                player.sendMessage("You can't remove a place that hasn't been saved!");
            } else {
                PlaceData.PlaceNames.remove(placeKey);
            }
            

//            Map<String, Object> places = PlacesManager.get().getConfigurationSection("Places").getValues(false);
//            MemorySection placeInfoObject = (MemorySection) places.get(placeKey);
//
//            Map<String, Object> placeInfo = (placeInfoObject.getValues(false));
//
//            if(placeInfo.containsKey(placeName)){
//                placeInfo.replace(placeKey, placeKey, null);
//
//                PlacesManager.save();
//                PlacesManager.reload();
//                player.sendMessage("You removed " + placeName + ", " + dimension);
//            } else {
//                player.sendMessage("This place does not exist!");
//            }
        }
        return false;
    }

}
