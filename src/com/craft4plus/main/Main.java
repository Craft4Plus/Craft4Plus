package com.craft4plus.main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Craft4Plus has been enabled!");
	}
	
	@Override
	public void onDisable() {
		System.out.println("Craft4Plus has been disabled!");
	}

}
