package nl.skelic.sc.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import nl.skelic.sc.Core;
import nl.skelic.sc.objects.ShulkerCrate;

public class Util {

	private static Core plugin;
	
	//public static final String prefix = Configs.getConfigs().color(Configs.getConfigs().getConfig().getString("Prefix")) + " " + ChatColor.RESET;
	
	public Util(Core plugin) {
		Util.plugin = plugin;
	}
	
	public static String color(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
	public void saveYML(File file, YamlConfiguration config) {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveFile(FileConfiguration config, File file) {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public static void copy(String orgMap, String original, String newMap, String copy) {
    	Path src =  Paths.get(plugin.getDataFolder() + File.separator + orgMap + File.separator + original);
    	Path dest = Paths.get(plugin.getDataFolder() + File.separator + newMap + File.separator + copy);
    	if (!Files.exists(dest)) {
    		try {
    			Files.copy(src, dest);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}	
    	} else {
    		return;
    	}
    }
    
//    public static final Block getTargetBlock(Player player, int range) {
//        BlockIterator iter = new BlockIterator(player, range);
//        Block lastBlock = iter.next();
//        while (iter.hasNext()) {
//            lastBlock = iter.next();
//            if (lastBlock.getType() == Material.AIR) {
//                continue;
//            }
//            break;
//        }
//        return lastBlock;
//    }
    
    public static void delete(String map, String file) {
    	Path src =  Paths.get(plugin.getDataFolder() + File.separator + map + File.separator + file);
    	if (Files.exists(src)) {
    		try {
    			Files.delete(src);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}	
    	} else {
    		return;
    	}
    }
    
    public static boolean compareLocation(Location location1, Location location2) {
    	if(location1.getBlockX() == location2.getBlockX()) {
    		if(location1.getBlockY() == location2.getBlockY()) {
    			if(location1.getBlockZ() == location2.getBlockZ()) {
    				if(location1.getWorld().getName().equals(location2.getWorld().getName())) {
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    public static boolean isNumber(String s) {
    	try {
    		Integer.parseInt(s);
    	} catch(Exception e) {
    		return false;
    	}
    	return true;
    }
    
    public static Location formatLocation(World world, int x, int y, int z) {
    	return new Location(world, x, y, z);
    }

	public static int getHighestId(Map<Integer, ShulkerCrate> crates) {
		int highestId = 0;
		
		for(int id : crates.keySet()) {
			if(id > highestId) highestId = id;
		}
		
		return highestId;
	}

	public static Location formatLocation(World world, double x, double y, double z) {
		return new Location(world, x, y, z);
	}
	
}
