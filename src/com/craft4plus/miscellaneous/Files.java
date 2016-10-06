package com.craft4plus.miscellaneous;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import com.craft4plus.main.Main;

public class Files {

	public static void save(Object object, File file) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream (file));
			
			oos.writeObject(object);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object load(File file) {
		try {
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			 Object result = ois.readObject();
			 ois.close();
			 return result;
		} catch (Exception e) {
			return null;
		}
	}
	
    public static String getSerializedLocation(Location loc) { //Converts location -> String
        return loc.getX() + ";" + loc.getY() + ";" + loc.getZ() + ";" + loc.getWorld().getUID() + ";" + loc.getPitch() + ";" + loc.getYaw();
        //feel free to use something to split them other than semicolons (Don't use periods or numbers)
    }
 
    public static Location getDeserializedLocation(String s) {//Converts String -> Location
            String [] parts = s.split(";"); //If you changed the semicolon you must change it here too
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);
            double z = Double.parseDouble(parts[2]);
            UUID u = UUID.fromString(parts[3]);
            float pitch = Float.parseFloat(parts[4]);
            float yaw = Float.parseFloat(parts[5]);
            if (Bukkit.getServer().getWorld(u) == null) {
            	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() { //Schedule a repeating task
    				@Override
    				public void run() {    		            
    				}
    			}, 1200L);
            	World w = Bukkit.getServer().getWorld(u);
                return new Location(w, x, y, z, yaw, pitch); //can return null if the world no longer exists
            } else {
            	World w = Bukkit.getServer().getWorld(u);
                return new Location(w, x, y, z, yaw, pitch); //can return null if the world no longer exists
            }
    }
	
}
