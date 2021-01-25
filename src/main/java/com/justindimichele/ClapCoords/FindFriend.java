package com.justindimichele.ClapCoords;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FindFriend implements CommandExecutor {
    public final ClapCoords plugin;

    public FindFriend (ClapCoords plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(command.getName().equalsIgnoreCase("findfriend"))
        {
            if(!(sender instanceof Player))
            {
                sender.sendMessage("You must be a player in order to run this command.");
            }
        }

        Player friendName = Bukkit.getPlayer(args[0]);

        if (friendName == null)
        {
            sender.sendMessage(args[0] + "is not currently online.");
        }

        assert friendName != null;
        Location friendCoords = friendName.getLocation();
        sender.sendMessage(friendName.getName() + " is at " + friendCoords.getBlockX() + ", " + friendCoords.getBlockY() + ", " + friendCoords.getBlockZ() + ".");
        return true;
    }
}
