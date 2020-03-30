package nl.skelic.sc.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import nl.skelic.sc.Core;

public class MenusBACKUP {
	
	
	/*public Menus(Core plugin) {
	}
	
	public static void pickerMenu(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, "Crates");
		
		ItemStack closeIcon = new ItemStack(Material.BARRIER, 1);
		ItemMeta closeMeta = closeIcon.getItemMeta();
		closeMeta.setDisplayName("§c§lCLOSE");
		closeIcon.setItemMeta(closeMeta);
		
		ItemStack borderIcon = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
		ItemMeta borderMeta = borderIcon.getItemMeta();
		borderMeta.setDisplayName("");
		borderIcon.setItemMeta(borderMeta);
		
		//ShulkerCrate List
		ItemStack commonCrateIcon = new ItemStack(Material.LIME_SHULKER_BOX, 1);
		ItemMeta commonCrateMeta = commonCrateIcon.getItemMeta();
		commonCrateMeta.setDisplayName("§a§lCommon ShulkerCrate");
		commonCrateIcon.setItemMeta(commonCrateMeta);
		
		ItemStack unCommonCrateIcon = new ItemStack(Material.GREEN_SHULKER_BOX, 1);
		ItemMeta unCommonCrateMeta = unCommonCrateIcon.getItemMeta();
		unCommonCrateMeta.setDisplayName("§2§lUnCommon ShulkerCrate");
		unCommonCrateIcon.setItemMeta(unCommonCrateMeta);
		
		ItemStack rareCrateIcon = new ItemStack(Material.BLUE_SHULKER_BOX, 1);
		ItemMeta rareCrateMeta = rareCrateIcon.getItemMeta();
		rareCrateMeta.setDisplayName("§9§lRare ShulkerCrate");
		rareCrateIcon.setItemMeta(rareCrateMeta);
		
		ItemStack epicCrateIcon = new ItemStack(Material.PURPLE_SHULKER_BOX, 1);
		ItemMeta epicCrateMeta = epicCrateIcon.getItemMeta();
		epicCrateMeta.setDisplayName("§5§lEpic ShulkerCrate");
		epicCrateIcon.setItemMeta(epicCrateMeta);
		
		ItemStack legendaryCrateIcon = new ItemStack(Material.YELLOW_SHULKER_BOX, 1);
		ItemMeta legendaryCrateMeta = legendaryCrateIcon.getItemMeta();
		legendaryCrateMeta.setDisplayName("§6§lLegendary ShulkerCrate");
		legendaryCrateIcon.setItemMeta(legendaryCrateMeta);
		
		inv.setItem(11, commonCrateIcon);
		inv.setItem(12, unCommonCrateIcon);
		inv.setItem(13, rareCrateIcon);
		inv.setItem(14, epicCrateIcon);
		inv.setItem(15, legendaryCrateIcon);
		
		inv.setItem(27 - 5, closeIcon);
		
		for (int i = 0; i < inv.getContents().length; i++) {
			ItemStack is = inv.getItem(i);
	        if ((i >= 0 && i <= 8) || (i >= 27 - 8 && i <= 27 - 1) || (i % 9 == 0) || ((i-8) % 9 == 0)) {
	        	if (is == null || is.getType() == Material.AIR) {
	        		inv.setItem(i, borderIcon);
	        	}
	        }
	    }
		
		p.openInventory(inv);
	}*/
	
}
