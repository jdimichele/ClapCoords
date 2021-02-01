package com.justindimichele.ClapCoords.Data;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlacesManager {

    private static File file;
    private static FileConfiguration placesFile;

    public static void configSetup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ClapCoords").getDataFolder(), "places.yml");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e){
                System.out.println("Could not create new " + placesFile + ".");
            }
        }
        placesFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return placesFile;
    }

    public static void save() {
        try {
            placesFile.save(file);
        } catch(IOException e){
            System.out.println("File could not be saved!");
        }
    }

    public static void reload() {
        placesFile = YamlConfiguration.loadConfiguration(file);
    }
}
