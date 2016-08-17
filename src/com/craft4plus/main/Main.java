package com.craft4plus.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.craft4plus.parties.Parties;
import com.craft4plus.tips.Tips;

public class Main extends JavaPlugin implements Listener {
	
	public static JavaPlugin instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		registerEvents();
		
		repeatingTasksPerMinute();
		
		System.out.println("Craft4Plus has been enabled!");
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
		pm.registerEvents(new Parties(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Craft4Plus has been disabled!");
	}
}