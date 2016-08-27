package com.craft4plus.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.craft4plus.listeners.PlayerJoin;

import java.util.List;

public class PlayerLeave implements Listener {

	private PlayerJoin PlayerJustJoinedList; //PlayerJoinList from the PlayerJoin class
	
	@EventHandler
	public void onPlayerLeave (PlayerQuitEvent event) {
		Player player = event.getPlayer();
		
		PlayerJustJoinedList = new PlayerJoin(); //PlayerJoinList from the PlayerJoin class
	    List<String> PlayerJustJoined = PlayerJustJoinedList.getList(); //PlayerJoinList from the PlayerJoin class
	    
	    if (PlayerJustJoined != null) {
	    if (PlayerJustJoined.contains(player.getName())); { //Check if player is in the just joined list
	    	PlayerJustJoined.remove(player.getName()); //Remove him
	    }
	    
	    }
				
	}
	
}
