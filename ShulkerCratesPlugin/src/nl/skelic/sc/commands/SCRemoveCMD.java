package nl.skelic.sc.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import nl.skelic.sc.Core;

public class SCRemoveCMD extends SCDefaultCMD {
	
	private Core core;
	
	public SCRemoveCMD(ShulkerCratesCMD executor, Core core) {
		super("remove", "/shulkercrates remove", core.getConfigs().getLang().getString("commands.sc-remove"), "shulkercrates.remove");
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
		
		if (!core.getShulkerManager().exists(bLoc)) {
			p.sendMessage(core.getPrefix() + ChatColor.RED + "The crate you are trying to remove does not exist.");
			return;
		}
		
		p.sendMessage("" + core.getShulkerManager().getCrate(bLoc.getBlock().getLocation()).getId());
		
		core.getShulkerManager().removeCrate(bLoc);
		
		p.playSound(pLoc, Sound.ENTITY_TNT_PRIMED, 1, (float) 1.5);
		p.sendMessage(core.getPrefix() + ChatColor.GREEN + "The crate has been successfully removed.");
	}
}
