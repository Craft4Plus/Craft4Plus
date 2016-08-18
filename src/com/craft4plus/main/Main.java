package com.craft4plus.main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.craft4plus.detection.Detection;
import com.craft4plus.parties.PartyInvite;
import com.craft4plus.tips.Tips;

public class Main extends JavaPlugin implements Listener, CommandExecutor {
	
	public static JavaPlugin instance;
	
	public void onEnable() {
		instance = this;
		
		registerCommands();
		
		registerEvents();
		
		repeatingTasksPerMinute();
		
		System.out.println("Craft4Plus has been enabled!");
	}
	
	private void registerCommands() {
		getCommand("party").setExecutor(new PartyInvite());
	}

	public void repeatingTasksPerMinute() {
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() { //Schedule a repeating task
			Tips tips = new Tips();
			@Override
			public void run() {
			tips.showTips();
			}
		}, 0L, 1200L);
	}

	public void registerEvents(){
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(this, this);
		pm.registerEvents(new Detection(), this);
	}

	@Override
	public void onDisable() {
		System.out.println("Craft4Plus has been disabled!");
	}
}