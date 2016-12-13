package com.craft4plus.islandclash;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.intellectualcrafters.plot.object.Plot;
import com.plotsquared.bukkit.events.PlayerClaimPlotEvent;

public class PlotSquaredListener implements Listener {
	
	@EventHandler
	public void addToTeam(PlayerClaimPlotEvent event) {
		Plot plot = event.getPlot();
		
		if (!plot.getCenter().getWorld().equals("IslandClash")) return;
		
		Player player = event.getPlayer();
		
		TeamStorage.addToRandomTeam(player);
		
		player.sendMessage("In " + TeamStorage.getTeam(player).toString());
		
	}

}
