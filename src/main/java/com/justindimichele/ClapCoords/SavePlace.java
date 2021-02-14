package com.justindimichele.ClapCoords;

import com.justindimichele.ClapCoords.Data.PlaceData;
import com.justindimichele.ClapCoords.Data.PlacesManager;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * SavePlace class allows the user to save a targeted block's location with a custom name, along with the following:
 *
 * Name - User set name for the place being saved.
 * Player - Storing the name of the user who executed the command.
 * PlayerID - Player UUID.
 * Location - Stores the XYZ coordinates of the users target block.
 * Dimension - Stores the environment of the location. (Nether, End, Overworld.)
 *
 * Then returns a string to the user of the saved place with the name set and XYZ coordinates.
 */

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
                String dimension = player.getWorld().getEnvironment().toString().toLowerCase();


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
                    placeData.put("Dimension", dimension);
                    places.put(placeKey, placeData);

                    PlacesManager.get().createSection("Places", places);
                    PlacesManager.save();

                    PlacesManager.reload();
                    player.sendMessage("You saved " + targetBlock.getX() + ", " + targetBlock.getY() + ", " + targetBlock.getZ()
                        + " as " + placeName + ", " + dimension);

                    PlaceData.PlaceNames.add(placeName);
                    PlaceData.sortPlaceNames();
                }
                return true;
        }
        return false;
    }
}
