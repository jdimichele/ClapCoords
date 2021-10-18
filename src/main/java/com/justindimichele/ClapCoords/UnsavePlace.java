package com.justindimichele.ClapCoords;

import com.justindimichele.ClapCoords.Data.PlaceData;
import com.justindimichele.ClapCoords.Data.PlacesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UnsavePlace implements CommandExecutor, TabCompleter {
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

            Map<String, Object> places = PlacesManager.get().getConfigurationSection("Places").getValues(true);
            MemorySection placeInfoObject = (MemorySection) places.get(placeKey);

            Map<String, Object> placeInfo = (placeInfoObject.getValues(false));
            if(placeInfo == null){
                player.sendMessage("Can't unsave something that doesn't exist yet.");
            } else {
                placeInfo.remove(placeKey);
                player.sendMessage("Place has been deleted!");
            }
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
