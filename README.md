# 👏 ClapCoords 👏 

### A Spigot plugin to help you keep track of friends, buildings, and more!
A group of friends and I realized one of the most annoying things while playing together was constantly asking for each other coordinates or where any player built structure was. To help with that, ClapCoords was made!

_Huge thanks to Keith Swanger for your help with this!_

## Plugin Features:
- **FindFriend Command**
    - Command allows players to find any online players (including themselves) and returns XYZ coordinates.
    - **Usage:** /findfriend playerName


- **SavePlace Command**
   - Command allows players to save XYZ coordinates of a single block that would be a label for a player built building, ravine, or anything else you can think of! The command will not only save the name of the place, but the User who has saved it along with their PlayerID in the places.yml file.
   - **Usage:** /saveplace placeName


- **FindPlaces Command**
    - Command allows you to search for any saved place by name.
    - **Usage:** /findplaces placeName

## TO-DO:
- [x] Create better alias for each command that will make it easier to execute. (IE: _/ff_ instead of _/findfriend_)
- [x] Create auto pop up list that pulls from the places.yml for all places saved. Current implementation does not do this, you'll need to know the name of the place specifically.
- [ ] Add ability to remove a saved place and have specific permission to do so. (Either admin or only players who have saved a place can remove the place they have saved.)
- [ ] Add ability to list all specific locations made by a player. (IE: _/list_ <player name> will display all the places that they've saved.)
- [x] Add ability to use /findfriends command without an additional argument and show all online player coordinates.
- [ ] Potentially a compass object?
