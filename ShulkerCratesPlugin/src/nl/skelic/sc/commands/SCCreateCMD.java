package nl.skelic.sc.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import nl.skelic.sc.Core;
import nl.skelic.sc.utils.Util;

public class SCCreateCMD extends SCDefaultCMD {
	
	private Core core;
	
	public SCCreateCMD(ShulkerCratesCMD executor, Core core) {
		super("Create", "/shulkercrates create", core.getConfigs().getLang().getString("commands.sc-create"), "shulkercrates.create");
		this.core = core;
	}
	
	@Override
	public void run(Player p, String[] args) {
		Block tBlock = p.getTargetBlockExact(5);
		
		Location bLoc = tBlock.getLocation();
		Location pLoc = p.getLocation();
		
		if (!tBlock.getType().name().endsWith("SHULKER_BOX")) {
			p.sendMessage(core.getPrefix() + ChatColor.RED + "The block you are looking at is not a Shulker Box");
			return;
		}
		
		if(core.getShulkerManager().exists(bLoc)) {
			p.sendMessage(core.getPrefix() + ChatColor.RED + "There already is a crate on that location.");
			return;
		}
		
		int id = core.getShulkerManager().createCrate(bLoc.getWorld().getName(), bLoc.getBlockX(), bLoc.getBlockY(), bLoc.getBlockZ());
		
		p.sendMessage(core.getPrefix() + ChatColor.GREEN + "ShulkerCrate has been created with the id " + ChatColor.WHITE + id + ChatColor.GREEN + "!");
		
		p.playSound(pLoc, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
	}
}
