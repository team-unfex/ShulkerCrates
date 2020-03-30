package nl.skelic.sc.managers;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

import nl.skelic.sc.Core;
import nl.skelic.sc.objects.ShulkerCrate;
import nl.skelic.sc.utils.Util;

public class ShulkerManager {
	
	private Core core;
	
	private static Map<Integer, ShulkerCrate> crates = new HashMap<>();;
	
	public ShulkerManager(Core core) {
		this.core = core;
	}
	
	public int createCrate(String world, int blockX, int blockY, int blockZ) {
		int id = generateId();
		
		ShulkerCrate crate = new ShulkerCrate(core, id, Bukkit.getWorld(world), blockX, blockY, blockZ);
		
		crates.put(id, crate);
		
		saveCrate(crate);
		
//		String BoxColor = core.getConfigs().getCrates().getString("ShulkerCrates.BoxColor") + "_SHULKER_BOX";
//		
//		if (BoxColor.contains(" ")) {
//			BoxColor.replaceAll(" ", "_");
//		}
//		
//		location.getBlock().setType(Material.getMaterial(BoxColor.toUpperCase()));
		
		core.getHoloManager().summonSCHolograms();
		
		return id;
	}
	
	public void loadCrates() {
		if(core.getConfigs().getCrates().getConfigurationSection("Crates") == null) {
			Bukkit.getConsoleSender().sendMessage(core.getPrefix() + "There are no crates created(yet).");
			return;
		}
		
		for (String id : core.getConfigs().getCrates().getConfigurationSection("Crates").getKeys(false)) {
			if(Util.isNumber(id)) {
				int theId = Integer.parseInt(id);
				String world = core.getConfigs().getCrates().getString("Crates." + theId + ".location.world");
				int x = core.getConfigs().getCrates().getInt("Crates." + theId + ".location.x");
				int y = core.getConfigs().getCrates().getInt("Crates." + theId + ".location.y");
				int z = core.getConfigs().getCrates().getInt("Crates." + theId + ".location.z");
				
				
				ShulkerCrate crate = new ShulkerCrate(core, theId, Bukkit.getWorld(world), x, y, z);
				crates.put(theId, crate);
				
			}
		}
	}

	private void saveCrate(ShulkerCrate crate) {
		int id = crate.getId();
		core.getConfigs().getCrates().set("Crates." + id + ".location.world", crate.getWorld().getName());
		core.getConfigs().getCrates().set("Crates." + id + ".location.x", crate.getX());
		core.getConfigs().getCrates().set("Crates." + id + ".location.y", crate.getY());
		core.getConfigs().getCrates().set("Crates." + id + ".location.z", crate.getZ());
		core.getConfigs().save(core.getConfigs().getCrates(), core.getConfigs().getCratesFile());
	}
	
	public ShulkerCrate getCrate(Location location) {
		for(ShulkerCrate crate : crates.values()) {
			if(crate.getX() == location.getBlockX() && crate.getY() == location.getBlockY() && crate.getZ() == location.getBlockZ() && crate.getWorld().getName() == location.getWorld().getName()) {
				return crate;
			}
		}
		return null;
	}
	
	public boolean exists(Location location) {
		for(ShulkerCrate crate : crates.values()) {
			if(crate.getX() == location.getBlockX() && crate.getY() == location.getBlockY() && crate.getZ() == location.getBlockZ() && crate.getWorld().getName() == location.getWorld().getName()) {
				return true;
			}
		}
		return false;
	}

	private int generateId() {
		if(crates.size() == 0) return 1;
		
		return Util.getHighestId(crates) + 1;
	}
	
	public Map<Integer, ShulkerCrate> getCrates() {
		return crates;
	}

	public void removeCrate(Location location) {
		ShulkerCrate crate = getCrate(location);
		
		Location crateLoc = Util.formatLocation(crate.getWorld(), crate.getX(), crate.getY(), crate.getZ());
		
		crateLoc.getBlock().setType(Material.AIR);
		
		core.getConfigs().getCrates().set("Crates." + crate.getId(), null);
		core.getConfigs().save(core.getConfigs().getCrates(), core.getConfigs().getCratesFile());
		
		core.getHoloManager().getHologram(crate).remove();
		core.getHoloManager().removeHologram(crate);
		
		crates.remove(crate.getId());
	}
	
	public void removeSCrates() {
 		crates.clear();
  	}

	public ShulkerCrate getCrate(int id) {
		return crates.get(id);
	}

}
