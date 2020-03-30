package nl.skelic.sc.commands;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import nl.skelic.sc.Core;
import nl.skelic.sc.managers.ShulkerManager;
import nl.skelic.sc.objects.ShulkerCrate;

public class SCListCMD extends SCDefaultCMD {
	
	public Core core;
	
	private ShulkerCratesCMD executor;
	
	public SCListCMD(ShulkerCratesCMD executor, Core core) {
		super("List", "/shulkercrates list", core.getConfigs().getLang().getString("commands.sc-list"), "shulkercrates.list");
		this.executor = executor;
		this.core = core;	
	}
	
	@Override
	void run(Player p, String[] args) {
		if(core.getShulkerManager().getCrates().size() == 0) {
			p.sendMessage(ChatColor.GRAY + "-==========- " + ChatColor.LIGHT_PURPLE + "Crates List" + ChatColor.GRAY + " -==========-");
			p.sendMessage(ChatColor.LIGHT_PURPLE + "There are no crates created(yet).");
			p.sendMessage(ChatColor.GRAY + "-===================================-");
			return;
		}
		
		p.sendMessage(ChatColor.GRAY + "-==========- " + ChatColor.LIGHT_PURPLE + "Crates List" + ChatColor.GRAY + " -==========-");
//		for (Map.Entry<String, Object> crate : core.getConfigs().getCrates().getConfigurationSection("Crates").getValues(false).entrySet()) {
//			p.sendMessage(ChatColor.LIGHT_PURPLE + crate.getKey() + ". " + "Location: " + core.getConfigs().getCrates().getDouble("Crates." + crate.getKey() + ".location.x") + " " + core.getConfigs().getCrates().getDouble("Crates." + crate.getKey() + ".location.y") + " " + core.getConfigs().getCrates().getDouble("Crates." + crate.getKey() + ".location.z") + " in World: " + core.getConfigs().getCrates().getDouble("Crates." + crate.getKey() + ".location.world"));
//		}
		
		for(ShulkerCrate crate : core.getShulkerManager().getCrates().values()) {
			p.sendMessage("" + ChatColor.LIGHT_PURPLE + crate.getId() + ". " + "Location: " + ChatColor.GRAY + crate.getX() + " " + crate.getY() + " " + crate.getZ() + ChatColor.LIGHT_PURPLE + " in World:" + ChatColor.GRAY + crate.getWorld().getName());
		}
		
//		for(int id : core.getShulkerManager().getCrates().keySet()) {
//			ShulkerCrate crate = core.getShulkerManager().getCrate(id);
//			p.sendMessage("" + ChatColor.LIGHT_PURPLE + crate.getId() + ". " + "Location: " + ChatColor.GRAY + crate.getLocation().getBlockX() + " " + crate.getLocation().getBlockY() + " " + crate.getLocation().getBlockZ() + ChatColor.LIGHT_PURPLE + " in World:" + ChatColor.GRAY + crate.getLocation().getWorld().getName());
//			p.sendMessage("" + ChatColor.LIGHT_PURPLE + crate.getId() + ". " + "Location: " + ChatColor.GRAY + crate.getLocation() + ChatColor.LIGHT_PURPLE + " in World:" + ChatColor.GRAY + crate.getLocation().getWorld().getName());
//		}
		p.sendMessage(ChatColor.GRAY + "-===================================-");
		
	}
}
