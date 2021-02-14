package com.justindimichele.ClapCoords;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class FindFriend implements CommandExecutor {
    public final ClapCoords plugin;
    public FindFriend (ClapCoords plugin){
        this.plugin = plugin;
    }

    /**
     *  FindFriend class allows the sender to find selected players XYZ coordinates. The friend can either be specified
     *  after typing the command, or can be used to show all online players XYZ coordinates.
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("findfriend") || command.getName().equalsIgnoreCase(label)) {

            Player friendName = null;
            if(args.length > 0) {
                friendName = Bukkit.getPlayer(args[0]);
            }

            if (friendName != null) {
                Location friendCoords = friendName.getLocation();
                sender.sendMessage(friendName.getName() + " is at " + friendCoords.getBlockX() + ", " + friendCoords.getBlockY() + ", " + friendCoords.getBlockZ() + ".");
            } else {
                Collection<? extends Player> allFriends = Bukkit.getServer().getOnlinePlayers();
                List<Player> sortedFriends = new ArrayList<Player>();
                for (Player player : allFriends){
                    sortedFriends.add(player);
                }

                sortedFriends.sort((n1, n2) -> n1.getName().compareTo(n2.getName()));

                for (Player player : sortedFriends) {
                    sender.sendMessage(player.getName() + " is at " + player.getLocation().getBlockX() +
                            ", " + player.getLocation().getBlockY() + ", " + player.getLocation().getBlockZ() + ".");
                }
            }
            return true;
        }
        sender.sendMessage(command.getUsage());
        return false;
    }
}


