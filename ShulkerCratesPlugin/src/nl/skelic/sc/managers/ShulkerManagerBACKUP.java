package nl.skelic.sc.managers;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.bukkit.Bukkit;
//import org.bukkit.Location;
//import org.bukkit.Material;
//
//import nl.skelic.sc.Core;
//import nl.skelic.sc.objects.ShulkerCrate;
//import nl.skelic.sc.utils.Util;
//
public class ShulkerManagerBACKUP {
//	
//	private Core core;
//	
//	public ShulkerManager(Core core) {
//		this.core = core;
//	}
//	
//	public ShulkerCrate getCrate(int id) {
//		return crates.get(key);
//	}
//	
//	public int createCrate(Location location) {
//		int id = getHighestId() + 1;
//		
//		Bukkit.getConsoleSender().sendMessage(core.getPrefix() + "Create a Crate with id " + id);
//		
//		Location blockLocation = new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ());
//		
//		location.getBlock().setType(Material.WHITE_SHULKER_BOX);
//		
//		crates.put(id, new ShulkerCrate(id, blockLocation));
//		
//		core.getConfigs().getCrates().set("Crates." + id + ".location.world", blockLocation.getWorld().getName());
//		core.getConfigs().getCrates().set("Crates." + id + ".location.x", blockLocation.getBlockX());
//		core.getConfigs().getCrates().set("Crates." + id + ".location.y", blockLocation.getBlockY());
//		core.getConfigs().getCrates().set("Crates." + id + ".location.z", blockLocation.getBlockZ());
//		core.getConfigs().save(core.getConfigs().getCrates(), core.getConfigs().getCratesFile());
//		
//		//core.getHolograms().createHolo(location.getWorld(), location);
//		core.getHoloManager().summonSCHolograms();
//		
//		return id;
//	}
//	
//	public ShulkerCrate getCrate(Location loc) {
//		for (ShulkerCrate crate : crates) {
//			if(Util.compareLocation(loc, crate.getLocation())) return crate;
//		}
//		return null;
//	}
//	
//	public void removeCrate(Location location) {
//		ShulkerCrate crate = getCrate(location);
//		
//		Location crateLoc = crate.getLocation();
//		
//		location.getBlock().setType(Material.AIR);
//		
//		crates.remove(crate);
//		
//		core.getConfigs().getCrates().set("Crates." + crate.getId(), null);
//		core.getConfigs().save(core.getConfigs().getCrates(), core.getConfigs().getCratesFile());
//		
//		core.getHoloManager().getHologram(crateLoc).remove();
//	}
//	
//	/*public void listCrates(Player p) {
//		if(core.getConfigs().getCrates().getConfigurationSection("Crates") == null) {
//			core.getLogger().info("There are no crates created(yet).");
//			return;
//		}
//		
//		for (int i = 0; i < crates.size(); i++) {
//			for (ShulkerCrate crate : crates) {
//				p.sendMessage(ChatColor.LIGHT_PURPLE + "" + (i++ < crates.size()) + ". " + ChatColor.DARK_PURPLE + "Location: " + crate.getLocation());
//				return;
//			}
//		}
//	}*/
//
//	public void loadCrates() {
//		if(core.getConfigs().getCrates().getConfigurationSection("Crates") == null) {
//			Bukkit.getConsoleSender().sendMessage(core.getPrefix() + "There are no crates created(yet).");
//			return;
//		}
//		/*BufferedReader reader = new BufferedReader(new FileReader(core.getConfigs().getCratesFile()));
//		boolean empty = reader.readLine() == null;
//		if (empty) {
//			Bukkit.getConsoleSender().sendMessage(core.prefix + "There are no crates created(yet).");
//			return;
//		}*/
//		
//		for (Map.Entry<String, Object> crate : core.getConfigs().getCrates().getConfigurationSection("Crates").getValues(false).entrySet()) {
//		//for(String id : core.getConfigs().getCrates().getConfigurationSection("Crates").getKeys(false)) {
//			if(Util.isNumber(crate.getKey())) {
//				int theId = Integer.parseInt(crate.getKey());
//				String world = core.getConfigs().getCrates().getString("Crates." + theId + ".location.world");
//				int x = core.getConfigs().getCrates().getInt("Crates." + theId + ".location.x");
//				int y = core.getConfigs().getCrates().getInt("Crates." + theId + ".location.y");
//				int z = core.getConfigs().getCrates().getInt("Crates." + theId + ".location.z");
//				
//				Location blockLocation = new Location(Bukkit.getWorld(world), x, y, z);
//								
//				getCrates().add(new ShulkerCrate(theId, blockLocation));
//				//Bukkit.getConsoleSender().sendMessage(core.getPrefix() + "Crate created for " + theId + " Location: " + x + " " + y + " " + z + " in World: " + world);
//				//Bukkit.getConsoleSender().sendMessage(core.getPrefix() + "crates in list: " + getCrates().size());
//				//Bukkit.getConsoleSender().sendMessage(core.getPrefix() + "crate location " + getCrates().get(theId).getLocation());
//			}
//		}
//		
//	}
//	
//	public boolean isLocation(Location loc1, Location loc2) {
//		if(loc1.getBlock().getX() == loc2.getBlock().getX()) {
//			core.getLogger().info("Loc check x\n Y = " + loc1.getBlock().getY() + " moet gelijk zijn aan " + loc2.getBlock().getY());
//			if(loc1.getBlock().getY() == loc2.getBlock().getY()) {
//				core.getLogger().info("Loc check y");
//				if(loc1.getBlock().getZ() == loc2.getBlock().getZ()) {
//					core.getLogger().info("Loc check z");
//					if(loc1.getWorld().getName() == loc2.getWorld().getName())
//						core.getLogger().info("Loc check name");
//						return true;
//				}
//			}
//		}
//		return false;
//	}
//	
//	public boolean exists(Location loc) {
//		for(int i = 0; i < getCrates().size(); i++) {
//			ShulkerCrate crate = getCrates().get(i);
//			if(Util.compareLocation(loc, crate.getLocation())) return true;
//		}
//		return false;
//	}
//	
//	public int getHighestId() {
//		int highestId = 0;
//		
//		if(crates.size() == 0) return 0;
//		
//		for(ShulkerCrate crate : crates) {
//			if(crate.getId() > highestId) highestId = crate.getId();
//		}
//		return highestId;
//	}
//	
//	/*public void summonSCrates() {
//		for (ShulkerCrate sc : getCrates()) {
//			Location loc = sc.getLocation();
//			if (getCrate(loc) == null) {
//				crates.add(new ShulkerCrate(sc.getId(), loc.getWorld().getName(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()));
//			}
//		}
//	}*/
//	
//	public void removeSCrates() {
//		for (ShulkerCrate sc : crates) {
//			sc.remove();
//		}
//		crates.clear();
//	}
//	
//	public List<ShulkerCrate> getCrates() {
//		return crates;
//	}
//
}
