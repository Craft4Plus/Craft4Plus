package com.craft4plus.main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcsg.survivalgames.SurvivalGames;

import com.craft4plus.afksystem.AFKSystem;
import com.craft4plus.listeners.PlayerJoin;
import com.craft4plus.listeners.PlayerLeave;
import com.craft4plus.listeners.PlayerWorldChange;
import com.craft4plus.minigames.LegacyPvP;
import com.craft4plus.minigames.kitpvp.KitPvPDeath;
import com.craft4plus.minigames.kitpvp.KitPvPItemDrops;
import com.craft4plus.minigames.parkour.Parkour;
import com.craft4plus.minigames.parkour.ParkourCommand;
import com.craft4plus.minigames.survivalgames.SGPlayerDetection;
import com.craft4plus.miscellaneous.MelonFaller;
import com.craft4plus.motd.MailPlaceholder;
import com.craft4plus.ranks.RanksCommand;
import com.craft4plus.tips.Tips;
import com.craft4plus.warpsystem.SetWarpCmd;
import com.craft4plus.warpsystem.WarpSystem;
import com.earth2me.essentials.Essentials;
import com.gmail.filoghost.chestcommands.ChestCommands;

import net.daboross.bukkitdev.skywars.api.SkyWars;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin implements Listener, CommandExecutor {
	
	public static JavaPlugin instance;
	
	public static Essentials ess; // Implement the Essentials API
	
	public static SkyWars sw; // Implement the SkyWars API
	
	public static SurvivalGames sg; // Implement the SkyWars API
	
	public static ChestCommands cc; // Implement the ChestCommands API
	
	public void onEnable() {
		instance = this;
		
		if (!setupEconomy() ) {
			System.out.println("Disabled due to no Vault dependency found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
        setupChat();
		
		sw = (SkyWars) Bukkit.getPluginManager().getPlugin("SkyWars"); // Implement the Skywars API
		
		sg = (SurvivalGames) Bukkit.getPluginManager().getPlugin("SurvivalGames"); // Implement the SurvivalGames API
		
		cc = (ChestCommands) Bukkit.getPluginManager().getPlugin("ChestCommands"); // Implement the SurvivalGames API
		
		registerCommands();
		
		registerEvents();
		
		repeatingTasksPerMinute();
		
		System.out.println("Craft4Plus has been enabled!");
	}
	
	private void registerCommands() {
		//Register Commands Here
		
		this.getCommand("ranks").setExecutor(new RanksCommand());
		this.getCommand("wp").setExecutor(new WarpSystem());
		this.getCommand("setwp").setExecutor(new SetWarpCmd());
		this.getCommand("parkourreset").setExecutor(new ParkourCommand());
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
		pm.registerEvents(new LegacyPvP(), this);
		pm.registerEvents(new SGPlayerDetection(), this);
		pm.registerEvents(new AFKSystem(), this);
		pm.registerEvents(new KitPvPItemDrops(), this);
		pm.registerEvents(new KitPvPDeath(), this);
		pm.registerEvents(new MelonFaller(), this);
		pm.registerEvents(new Parkour(), this);
		pm.registerEvents(new PlayerWorldChange(), this);
		
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
    public void onLoad() { // Works just like onEnable but is called way earlier
    	ess = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials"); // Implement the Essentials API
    	MailPlaceholder.registerMotdPlaceholders(); // MOTD Placeholders for ServerListPlus
    }
    
	@Override
	public void onDisable() {
		System.out.println("Craft4Plus has been disabled!");
	}

	public static Plugin getInstance() {
		return instance;
	}
}