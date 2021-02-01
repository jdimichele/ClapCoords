package com.justindimichele.ClapCoords;

import com.justindimichele.ClapCoords.Data.PlacesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;

import java.util.Map;

public class FindPlaces implements CommandExecutor {

    ClapCoords plugin;
    public FindPlaces (ClapCoords plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("findplaces")){
            Player player = (Player) sender;
            String placeName = "";
            for (int i = 0; i < args.length; i++) {
                placeName += args[i] + " ";
            }
            placeName = placeName.trim();
            String placeKey = placeName.toLowerCase();

            Map<String, Object> places = PlacesManager.get().getConfigurationSection("Places").getValues(true);
            MemorySection placeInfoObject = (MemorySection) places.get(placeKey);

            Map<String, Object> placeInfo = (placeInfoObject.getValues(false));
            if(placeInfo == null){
                player.sendMessage("null");
            } else {
                player.sendMessage(placeName + " is at " +  placeInfo.get("Location") + ".");
            }

            return true;
        }
        return false;
    }
}
