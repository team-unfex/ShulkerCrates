package nl.skelic.sc.menus;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import nl.skelic.lib.gui.MenuAPI;
import nl.skelic.sc.Core;

public class BuyKeysMenu extends MenuAPI {
	
	@SuppressWarnings("deprecation")
	public BuyKeysMenu(Core core, Player player, CratesMenu cratesMenu) {
		super("Buy Keys", 36);
		
		String playerName = player.getName();
		UUID playerUUID = player.getUniqueId();
		Economy econ = core.getEconomy();
		
		setContent(13, Material.TRIPWIRE_HOOK, ChatColor.YELLOW + "" + ChatColor.BOLD + "Keys Owned", ChatColor.WHITE + "Common Key: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Common") + "\n" +
																											ChatColor.WHITE + "UnCommon Key: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.UnCommon") + "\n" +
																											ChatColor.WHITE + "Rare Key: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Rare") + "\n" +
																											ChatColor.WHITE + "Epic Key: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Epic") + "\n" +
																											ChatColor.WHITE + "Legendary Key: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Legendary"), p -> {
			
		});
		
		setContent(20, Material.LIME_BANNER, ChatColor.GREEN + "" + ChatColor.BOLD + "Common Key", ChatColor.WHITE + "You have owned: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Common"), p -> {
			if (econ.getBalance(player.getName()) >= 100) {
				core.getConfigs().getPlayerData().set("Playerdata." + playerUUID + ".KeysOwned.Common", core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Common") + 1);
				core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
				econ.withdrawPlayer(player.getName(), 100);
				return;
			}
			p.sendMessage(core.getPrefix() + ChatColor.RED + "" + ChatColor.BOLD + "ERROR! " + ChatColor.RESET + "You dont have enough Balance");
		});
		
		setContent(21, Material.GREEN_BANNER, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "UnCommon Key", ChatColor.WHITE + "You have owned: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.UnCommon"), p -> {
			if (econ.getBalance(player.getName()) >= 200) {
				core.getConfigs().getPlayerData().set("Playerdata." + playerUUID + ".KeysOwned.UnCommon", core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.UnCommon") + 1);
				core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
				econ.withdrawPlayer(player.getName(), 200);
				return;
			}
			p.sendMessage(core.getPrefix() + ChatColor.RED + "" + ChatColor.BOLD + "ERROR! " + ChatColor.RESET + "You dont have enough Balance");
		});
		
		setContent(22, Material.BLUE_BANNER, ChatColor.BLUE + "" + ChatColor.BOLD + "Rare Key", ChatColor.WHITE + "You have owned: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Rare"), p -> {
			if (econ.getBalance(player.getName()) >= 300) {
				core.getConfigs().getPlayerData().set("Playerdata." + playerUUID + ".KeysOwned.Rare", core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Rare") + 1);
				core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
				econ.withdrawPlayer(player.getName(), 300);
				return;
			}
			p.sendMessage(core.getPrefix() + ChatColor.RED + "" + ChatColor.BOLD + "ERROR! " + ChatColor.RESET + "You dont have enough Balance");
		});
		
		setContent(23, Material.PURPLE_BANNER, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Epic Key", ChatColor.WHITE + "You have owned: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Epic"), p -> {
			if (econ.getBalance(player.getName()) >= 400) {
				core.getConfigs().getPlayerData().set("Playerdata." + playerUUID + ".KeysOwned.Epic", core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Epic") + 1);
				core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
				econ.withdrawPlayer(player.getName(), 400);
				return;
			}
			p.sendMessage(core.getPrefix() + ChatColor.RED + "" + ChatColor.BOLD + "ERROR! " + ChatColor.RESET + "You dont have enough Balance");
		});
		
		setContent(24, Material.YELLOW_BANNER, ChatColor.GOLD + "" + ChatColor.BOLD + "Legendary Key", ChatColor.WHITE + "You have owned: " + ChatColor.AQUA + core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Legendary"), p -> {
			if (econ.getBalance(player.getName()) >= 500) {
				core.getConfigs().getPlayerData().set("Playerdata." + playerUUID + ".KeysOwned.Legendary", core.getConfigs().getPlayerData().getInt("Playerdata." + playerUUID + ".KeysOwned.Legendary") + 1);
				core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
				econ.withdrawPlayer(player.getName(), 500);
				return;
			}
			p.sendMessage(core.getPrefix() + ChatColor.RED + "" + ChatColor.BOLD + "ERROR! " + ChatColor.RESET + "You dont have enough Balance");
		});
		
		setCustomSkullContent(getInv().getSize() - 5, "86971dd881dbaf4fd6bcaa93614493c612f869641ed59d1c9363a3666a5fa6", ChatColor.GRAY + "" + ChatColor.BOLD + "BACK", "", p -> {
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
