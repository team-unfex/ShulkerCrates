package nl.skelic.sc.menus;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;
import nl.skelic.lib.gui.MenuAPI;
import nl.skelic.sc.Core;
import nl.skelic.sc.objects.ShulkerCrate;

public class OpenCrateMenu extends MenuAPI {

	public OpenCrateMenu(Core core, String crateName, Player player, CratesMenu cratesMenu) {
		super("Crates", 36);
		
		Block tBlock = player.getTargetBlockExact(5);
		
		Location bLoc = tBlock.getLocation();
		Location pLoc = player.getLocation();
		
		ShulkerCrate crate = (ShulkerCrate) core.getShulkerManager().getCrate(bLoc);
		
		//Bukkit.broadcastMessage(crateName);
		
		if (crateName == "Common") {
			setContent(13, Material.LIME_SHULKER_BOX, ChatColor.WHITE + "Do you want to open the " + ChatColor.GREEN + "Common ShulkerCrate" + ChatColor.WHITE + "?", "", p -> {
				
			});
		}
		
		if (crateName == "UnCommon") {
			setContent(13, Material.GREEN_SHULKER_BOX, ChatColor.WHITE + "Do you want to open the " + ChatColor.DARK_GREEN + "UnCommon ShulkerCrate" + ChatColor.WHITE + "?", "", p -> {
				
			});
		}
		
		if (crateName == "Rare") {
			setContent(13, Material.BLUE_SHULKER_BOX, ChatColor.WHITE + "Do you want to open the " + ChatColor.BLUE + "Rare ShulkerCrate" + ChatColor.WHITE + "?", "", p -> {
				
			});
		}
		
		if (crateName == "Epic") {
			setContent(13, Material.PURPLE_SHULKER_BOX, ChatColor.WHITE + "Do you want to open the " + ChatColor.DARK_PURPLE + "Epic ShulkerCrate" + ChatColor.WHITE + "?", "", p -> {
				
			});
		}
		
		if (crateName == "Legendary") {
			setContent(13, Material.YELLOW_SHULKER_BOX, ChatColor.WHITE + "Do you want to open the " + ChatColor.GOLD + "Legendary ShulkerCrate" + ChatColor.WHITE + "?", "", p -> {
				
			});
		}
		
		setCustomSkullContent(20, "a92e31ffb59c90ab08fc9dc1fe26802035a3a47c42fee63423bcdb4262ecb9b6", ChatColor.GREEN + "" + ChatColor.BOLD + "YES", "", p -> {
			p.closeInventory();
			crate.getSCHolo().remove();
			p.sendMessage("opening crate...");
		});
		
		setCustomSkullContent(24, "beb588b21a6f98ad1ff4e085c552dcb050efc9cab427f46048f18fc803475f7", ChatColor.RED + "" + ChatColor.BOLD + "NO", "", p -> {
			cratesMenu.openMenu(p);
		});
		
		
		for (int i = 0; i < getInv().getSize(); i++) {
			ItemStack is = getInv().getItem(i);
	        if ((i >= 0 && i <= 8) || (i >= getInv().getSize() - 8 && i <= getInv().getSize() - 1) || (i % 9 == 0) || ((i-8) % 9 == 0)) {
	        	if (is == null || is.getType() == Material.AIR) {
	        		setContent(i, Material.BLACK_STAINED_GLASS_PANE, " ", "", p -> {
	        			
	        		});
	        	}
	        }
	    }
	}
	
	
	
}
