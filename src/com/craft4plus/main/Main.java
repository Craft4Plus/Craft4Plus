package com.craft4plus.main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.craft4plus.listeners.PlayerJoin;
import com.craft4plus.listeners.PlayerLeave;
import com.craft4plus.ranks.RanksCommand;
import com.craft4plus.tips.Tips;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin implements Listener, CommandExecutor {
	
	public static JavaPlugin instance;
	
	public void onEnable() {
		instance = this;
		
		if (!setupEconomy() ) {
			System.out.println("Disabled due to no Vault dependency found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
        setupChat();

		
		registerCommands();
		
		registerEvents();
		
		repeatingTasksPerMinute();
		
		System.out.println("Craft4Plus has been enabled!");
	}
	
	private void registerCommands() {
		//Register Commands Here
		
		this.getCommand("ranks").setExecutor(new RanksCommand());
	}

	public void repeatingTasksPerMinute() {
		
		//Everything under "public void run() {" will be run every minute
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() { //Schedule a repeating task
			Tips tips = new Tips();
			@Override
			public void run() {
			tips.showTips();
			}
		}, 0L, 1200L);
	}

	public void registerEvents(){
		//Register Listeners Here
		
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(this, this);
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerLeave(), this);
	}
	
	// VAULT API STUFF!
	
    public static Permission permission = null;
    public static Economy economy = null;
    public static Chat chat = null;

    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

    private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
    
    // END OF VAULT API STUFF!

	@Override
	public void onDisable() {
		System.out.println("Craft4Plus has been disabled!");
	}
}