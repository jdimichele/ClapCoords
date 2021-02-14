package com.justindimichele.ClapCoords.Data;


import org.bukkit.configuration.MemorySection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlaceData {
    /**
     *  PlaceData allows easy access of the following parameters throughout the rest of the plugin.
     *
     * @param placeName - returns the placeName set by the player.
     * @param playerName - returns the playerName of player who executed command.
     * @param playerID - returns the playerID of player who executed command.
     * @param placeLoc - returns the placeLoc of player's target block in XYZ coordinates.
     * @param dimension - returns the players current world environment. (ie: The Nether, The End, or normal/Overworld)
     */

    public String placeName;
    public String playerName;
    public String playerID;
    public String placeLoc;
    public String dimension;

    public static List<String> PlaceNames = new ArrayList<String>();


    public PlaceData(String placeName, String playerName, String playerID, String placeLoc, String dimension){
        this.placeName = placeName;
        this.playerName = playerName;
        this.playerID = playerID;
        this.placeLoc = placeLoc;
        this.dimension = dimension;
    }



    /**
     * loadAllPlaceData() method creates a new List with all retrieved PlaceData and adds each PlaceName set by the
     * sender
     */

    public static void loadAllPlaceData() {
        List<PlaceData> placeData = PlaceData.getAllPlaceData();
        for (PlaceData place : placeData) {
            PlaceData.PlaceNames.add(place.placeName);
        }
        sortPlaceNames();
    }

    /**
     * getAllPlaceData() method grabs from the places.yml file, checks if there is available data, and stores
     * each of the PlaceData variables in the namedPlaces List, then finally returns it.
     *
     * @return namedPlaces - Returns list of all saved named places from the places.yml.
     */


    public static List<PlaceData> getAllPlaceData() {
        Map<String, Object> places = PlacesManager.get().getConfigurationSection("Places").getValues(true);
        List<PlaceData> namedPlaces = new ArrayList<PlaceData>();

        if(places != null){
            for (Map.Entry<String, Object> entry : places.entrySet()) {
                Object placeMemSection = places.get(entry.getKey());
                if(placeMemSection instanceof MemorySection) {
                    MemorySection placesInfoObject = (MemorySection) placeMemSection;
                    Map<String, Object> placesInfo = (placesInfoObject.getValues(false));
                    namedPlaces.add(new PlaceData(
                            placesInfo.get("Name").toString(),
                            placesInfo.get("Player").toString(),
                            placesInfo.get("PlayerID").toString(),
                            placesInfo.get("Location").toString(),
                            placesInfo.get("Dimension").toString()));
                }
            }
        }
        return namedPlaces;
    }

    /**
     * sortPlaceNames() method sorts all place names when called.
     */

    public static void sortPlaceNames() {
        PlaceData.PlaceNames.sort((p1, p2) -> p1.compareTo(p2));
    }
}
