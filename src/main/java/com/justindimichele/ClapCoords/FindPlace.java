package com.justindimichele.ClapCoords;

import com.justindimichele.ClapCoords.Data.PlaceData;
import com.justindimichele.ClapCoords.Data.PlacesManager;
import org.bukkit.command.*;
import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class FindPlace implements CommandExecutor, TabCompleter {
    ClapCoords plugin;
    public FindPlace(ClapCoords plugin) {
        this.plugin = plugin;
    }

    /**
     * FindPlace allows the sender to find any place previously saved by another player on the server, including themselves.
     * Once command is typed, a TabCompleter list will appear with all saved places in the world that has been tagged by
     * other players.
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("findplace") || command.getName().equalsIgnoreCase(label)) {
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
            if (placeInfo == null) {
                player.sendMessage("Looks like this place doesn't exist yet.");
            } else {
                player.sendMessage(placeName + " is at " + placeInfo.get("Location") + ", in " + placeInfo.get("Dimension") + ".");
            }
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        if(args == null || args.length == 0 || args[0].equals("")){
            return PlaceData.PlaceNames;
        }

        List<String> TabPlaces;

        String placeName = "";
        for (int i = 0; i < args.length; i++) {
            placeName += args[i] + " ";
        }

        String finalPlaceName = placeName.toLowerCase().substring(0, placeName.length() - 1);
        TabPlaces = PlaceData.PlaceNames.stream().filter(x -> x.toLowerCase().startsWith(finalPlaceName)).collect(Collectors.toList());
        return TabPlaces;
    }

}
