# 👏 ClapCoords v1.1 👏
While I was pretty happy with the base functionality of v1.0, I soon realized there were some QoL changes that could be made and ultimately make the plugin more usable and less of a hassle. While most of these changes were noted in the first release "TO-DO" section, there are also some additional changes that felt more user friendly.

Thanks to Keith Swanger once again for all your help! 😄

# Release Notes:
## New Features:
* _Added FindPlace command_
  * _Purpose:_ FindPlace command displays available argument list of all the places that players have saved in the world. Select one of the saved places from the list, then hit tab, then enter, and... Bam! The selected place will return with XYZ coordinates.
  * FindPlace is not case-sensitive, so type as fast as you possibly can and fear not.
  * FindPlace has Tab Completion available with a list of all the saved places to find.
  * Added alias.

* _Modified SavePlace command_
  * SavePlace will now save whether the place saved is in the Nether, The End, or the Overworld. Check the Wiki for more information on how this is saved.
  * SavePlace now will warn you if a place has already been saved.

* _Modified FindPlaces command_
  * FindPlaces will now show all saved places with their XYZ coordinates.
  * Added alias.

* _Modified FindFriend command_
  * FindFriend will now show you all online friends with all their coordinates if no friend name is specifically chosen.
  * Added alias.

* _Added aliases for commands_
  * Now instead of typing out the commands entirely, you can use aliases to make the command execution time MUCH faster. (Example: instead of /findfriend <friendName>, now use /ff <friendName>)
  * Check the Wiki or README for more information on this.


## Additional Changes:
* Changed how the data is gathered and displayed from the places.yml file for easier and concise understanding.
* Added inline documentation to better explain how each method works.
* Added ClapCoords Wikipage to allow for easy look up on how to use the plugin.
* Cleaned up unnecessary white space/unused imports.

Lastly, I have some other ideas I'd like to implement for ClapCoords as I think it could be a useful plugin others might like to try out. I'll be updating the plugin periodically and also be updating the Wiki with more plans and the never-ending To-Do list I have setup. :)

Until then, thanks for checking out ClapCoords!

Justin