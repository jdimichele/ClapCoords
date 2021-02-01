package com.justindimichele.ClapCoords;

import com.justindimichele.ClapCoords.Data.PlacesManager;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;


public class SavePlace implements CommandExecutor {

    ClapCoords plugin;
    public SavePlace (ClapCoords plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if(command.getName().equalsIgnoreCase("saveplace")){
                Player player = (Player) sender;

                Block targetBlock = player.getTargetBlockExact(1000);
                assert targetBlock != null;

                String placeLocation = targetBlock.getX() + ", " + targetBlock.getY() + ", " + targetBlock.getZ();
                String placeName = "";
                for (int i = 0; i < args.length; i++) {
                    placeName += args[i] + " ";
                }
                placeName = placeName.trim();

                String placeKey = placeName.toLowerCase();

                if(!PlacesManager.get().isConfigurationSection("Places")){
                    PlacesManager.get().createSection("Places", new HashMap<String, Object>());
                }

                Map<String, Object> places =
                PlacesManager.get().getConfigurationSection("Places").getValues(false);

                if(places.containsKey(placeName)){
                    player.sendMessage("This place is already saved!");
                } else {
                    Map<String,Object> placeData = new HashMap<String,Object>();
                    placeData.put("Name", placeName);
                    placeData.put("Player", player.getDisplayName());
                    placeData.put("PlayerID", player.getUniqueId().toString());
                    placeData.put("Location", placeLocation);
                    places.put(placeKey, placeData);

                    PlacesManager.get().createSection("Places", places);
                    PlacesManager.save();

                    PlacesManager.reload();
                    player.sendMessage("You saved " + targetBlock.getX() + ", " + targetBlock.getY() + ", " + targetBlock.getZ()
                        + " as " + placeName);
                }
                return true;
        }
        return false;
    }
}
