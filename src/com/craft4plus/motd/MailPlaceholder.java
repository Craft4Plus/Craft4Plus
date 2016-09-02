package com.craft4plus.motd;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import com.craft4plus.main.Main;
import com.earth2me.essentials.User;

import net.minecrell.serverlistplus.core.ServerListPlusCore;
import net.minecrell.serverlistplus.core.player.PlayerIdentity;
import net.minecrell.serverlistplus.core.replacement.LiteralPlaceholder;
import net.minecrell.serverlistplus.core.replacement.ReplacementManager;
import net.minecrell.serverlistplus.core.status.StatusResponse;

public class MailPlaceholder {
	
	public static void registerMotdPlaceholders() {
        ReplacementManager.getDynamic().add(new LiteralPlaceholder("%mail%") { // Register placeholder %mail%
            @SuppressWarnings("deprecation") // For the offlinePlayer, which was made dpricated due to UUIDs
			@Override
            public String replace(StatusResponse response, String s) {
                PlayerIdentity identity = response.getRequest().getIdentity(); // Player from SLP
                if (identity != null) {
                    OfflinePlayer player = Bukkit.getOfflinePlayer(identity.getName()); // Offline player, since the player views this from the Server List.
                    User EssentialsUser = Main.ess.getUser(player); // Get the Essentials User
                    if (EssentialsUser != null) {
                    	if (EssentialsUser.getMails().isEmpty()) { // Mail is empty
                    		return this.replace(s, "You have no mail");
                    	} else {
                    		if (EssentialsUser.getMails().size() == 1) { // Mail is 1
                    			return this.replace(s, "You have 1 new mail");
                    		} else { // Mail is above 1
                    			return this.replace(s, "You have " + EssentialsUser.getMails().size() +" new mails");
                    		}
                    	}
                    
                    }
                } else // Use the method below if player is unknown
                    return super.replace(response, s);
				return s;
            }

            @Override
            public String replace(ServerListPlusCore core, String s) {
                // Unknown player, so let's just replace it with something unknown
                return "You may have mail";
            }
        });		
	}

}
