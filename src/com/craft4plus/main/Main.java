package com.craft4plus.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.craft4plus.tips.Tips;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
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
		@SuppressWarnings("unused")
		PluginManager pm = getServer().getPluginManager();
		
//		pm.registerEvents(new WhateverClassName(), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Craft4Plus has been disabled!");
	}
}