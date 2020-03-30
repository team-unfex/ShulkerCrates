package nl.skelic.sc.menus;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;
import nl.skelic.lib.gui.MenuAPI;
import nl.skelic.sc.Core;

public class CratesMenu extends MenuAPI {
	
//	public UUID getPlayerUUID() {
//		UUID uuid = null;
//		
//		for (Player p : Bukkit.getOnlinePlayers()) {
//			UUID id = p.getUniqueId();
//			
//			uuid = id;
//		}
//		
//		return uuid;
//	}
//	
//	public Player getPlayer() {
//		Player player = null;
//		
//		for (Player p : Bukkit.getOnlinePlayers()) {
//			Player pl = p;
//			
//			player = pl;
//		}
//		
//		return player;
//	}
	
	public CratesMenu(Player player, Core core) {
		super("Crates", 27);
		
		String playerName = player.getName();
		UUID playerUUID = player.getUniqueId();
		
		//Bukkit.broadcastMessage("Your Name = " + playerName);
		//Bukkit.broadcastMessage("Your UUID = " + playerUUID);
		
		setSkullContent(9 - 6, player, ChatColor.YELLOW + "" + ChatColor.BOLD + playerName + "'s Account", ChatColor.LIGHT_PURPLE + "" + ChatColor.UNDERLINE + "Cases Owned\n\n" + 
																											ChatColor.WHITE + "Common ShulkerCrate: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.Common") + "\n" +
																											ChatColor.WHITE + "UnCommon ShulkerCrate: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.UnCommon") + "\n" +
																											ChatColor.WHITE + "Rare ShulkerCrate: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.Rare") + "\n" +
																											ChatColor.WHITE + "Epic ShulkerCrate: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.Epic") + "\n" +
																											ChatColor.WHITE + "Legendary ShulkerCrate: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.Legendary"), p -> {
			
		});
		
		setContent(9 - 4, Material.TRIPWIRE_HOOK, ChatColor.YELLOW + "" + ChatColor.BOLD + "BUY KEYS", ChatColor.LIGHT_PURPLE + "" + ChatColor.UNDERLINE + "Keys Owned\n\n" + 
																										ChatColor.WHITE + "Common Key: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Common") + "\n" +
																										ChatColor.WHITE + "UnCommon Key: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.UnCommon") + "\n" +
																										ChatColor.WHITE + "Rare Key: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Rare") + "\n" +
																										ChatColor.WHITE + "Epic Key: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Epic") + "\n" +
																										ChatColor.WHITE + "Legendary Key: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Legendary"), p -> {
			new BuyKeysMenu(core, player, this).openMenu(p);																						
		});
		
		setContent(11, Material.LIME_SHULKER_BOX, ChatColor.GREEN + "" + ChatColor.BOLD + "Common ShulkerCrate", ChatColor.WHITE + "You have owned: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.Common"), p -> {
			if (core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.Common") >= 1) {
				if (core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Common") >= 1) {
					new OpenCrateMenu(core, "Common", player, this).openMenu(p);
					return;
				}
				p.closeInventory();
				p.sendMessage(core.getPrefix() + "You don't have the Common Key to open this Crate");
			}
			
		});
		
		setContent(12, Material.GREEN_SHULKER_BOX, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "UnCommon ShulkerCrate", ChatColor.WHITE + "You have owned: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.UnCommon"), p -> {
			if (core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.UnCommon") >= 1) {
				if (core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.UnCommon") >= 1) {
					new OpenCrateMenu(core, "UnCommon", player, this).openMenu(p);
					return;
				}
				p.closeInventory();
				p.sendMessage(core.getPrefix() + "You don't have the UnCommon Key to open this Crate");
			}
		});
		
		setContent(13, Material.BLUE_SHULKER_BOX, ChatColor.BLUE + "" + ChatColor.BOLD + "Rare ShulkerCrate", ChatColor.WHITE + "You have owned: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.Rare"), p -> {
			if (core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.Rare") >= 1) {
				if (core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Rare") >= 1) {
					new OpenCrateMenu(core, "Rare", player, this).openMenu(p);
					return;
				}
				p.closeInventory();
				p.sendMessage(core.getPrefix() + "You don't have the Rare Key to open this Crate");
			}
		});
		
		setContent(14, Material.PURPLE_SHULKER_BOX, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Epic ShulkerCrate", ChatColor.WHITE + "You have owned: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.Epic"), p -> {
			if (core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.Epic") >= 1) {
				if (core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Epic") >= 1) {
					new OpenCrateMenu(core, "Epic", player, this).openMenu(p);
					return;
				}
				p.closeInventory();
				p.sendMessage(core.getPrefix() + "You don't have the Epic Key to open this Crate");
			}
		});
		
		setContent(15, Material.YELLOW_SHULKER_BOX, ChatColor.GOLD + "" + ChatColor.BOLD + "Legendary ShulkerCrate", ChatColor.WHITE + "You have owned: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.Legendary"), p -> {
			if (core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".CasesOwned.Legendary") >= 1) {
				if (core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Legendary") >= 1) {
					new OpenCrateMenu(core, "Legendary", player, this).openMenu(p);
					return;
				}
				p.closeInventory();
				p.sendMessage(core.getPrefix() + "You don't have the Legendary Key to open this Crate");
			}
		});
		
		setContent(getInv().getSize() - 5, Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE", "", p -> {
			p.closeInventory();
		});
		
		for (int i = 0; i < getInv().getSize(); i++) {
			ItemStack is = getInv().getItem(i);
	        if ((i >= 0 && i <= 8) || (i >= 27 - 8 && i <= 27 - 1) || (i % 9 == 0) || ((i-8) % 9 == 0)) {
	        	if (is == null || is.getType() == Material.AIR) {
	        		setContent(i, Material.BLACK_STAINED_GLASS_PANE, " ", "", p -> {
	        			
	        		});
	        	}
	        }
	    }
	}

}
