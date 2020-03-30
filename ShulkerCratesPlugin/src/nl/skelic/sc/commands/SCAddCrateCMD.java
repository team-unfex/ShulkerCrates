package nl.skelic.sc.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import nl.skelic.sc.Core;

public class SCAddCrateCMD extends SCConsoleCMD {
	
	//private ShulkerCratesCMD executor;
	private Core core;
	
	public SCAddCrateCMD(ShulkerCratesCMD executor, Core core) {
		super("AddCrate", "/shulkercrates addcrate <target> <crate type> <amount>", core.getConfigs().getLang().getString("commands.sc-addcrate", "shulkercrates.addcrate"), "shulkercrates.addcrate");
		//this.executor = executor;
		this.core = core;
	}

	@Override
	void run(CommandSender sender, String[] args) {
		
		if(args.length != 4) {
			sender.sendMessage(core.getPrefix() + ChatColor.RED + "Wrong usage! " + ChatColor.GRAY + "Usage: " + ChatColor.LIGHT_PURPLE + getUsage());
			return;
		}
		
		if(Bukkit.getPlayer(args[1]) == null) {
			sender.sendMessage(core.getPrefix() + ChatColor.LIGHT_PURPLE + "Please enter a valid Player!");
			return;
		}
		
		UUID uuid = Bukkit.getPlayer(args[1]).getUniqueId();
		
		if(args[2].equalsIgnoreCase("common")) {
			if(!(args[3] == null)) {
				core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".CasesOwned.Common", core.getConfigs().getPlayerData().getInt("Playerdata." + uuid + ".CasesOwned.Common") + args[3].toString());
				core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
				sender.sendMessage(core.getPrefix() + ChatColor.LIGHT_PURPLE + args[3].toString() + " " + args[2].toString() + " Succesfully added to " + args[1].toString() + "'s Account");
			}
			sender.sendMessage(core.getPrefix() + ChatColor.LIGHT_PURPLE + "Please enter a specific amount!");
			return;
		}
		
		if(args[2].equalsIgnoreCase("uncommon")) {
			if(!(args[3] == null)) {
				core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".CasesOwned.UnCommon", core.getConfigs().getPlayerData().getInt("Playerdata." + uuid + ".CasesOwned.UnCommon") + args[3].toString());
				core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
				sender.sendMessage(core.getPrefix() + ChatColor.LIGHT_PURPLE + args[3].toString() + " " + args[2].toString() + " Succesfully added to " + args[1].toString() + "'s Account");
			}
			sender.sendMessage(core.getPrefix() + ChatColor.LIGHT_PURPLE + "Please enter a specific amount!");
			return;
		}
		
		if(args[2].equalsIgnoreCase("rare")) {
			if(!(args[3] == null)) {
				core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".CasesOwned.Rare", core.getConfigs().getPlayerData().getInt("Playerdata." + uuid + ".CasesOwned.Rare") + args[3].toString());
				core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
				sender.sendMessage(core.getPrefix() + ChatColor.LIGHT_PURPLE + args[3].toString() + " " + args[2].toString() + " Succesfully added to " + args[1].toString() + "'s Account");
			}
			sender.sendMessage(core.getPrefix() + ChatColor.LIGHT_PURPLE + "Please enter a specific amount!");
			return;
		}
		
		if(args[2].equalsIgnoreCase("epic")) {
			if(!(args[3] == null)) {
				core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".CasesOwned.Epic", core.getConfigs().getPlayerData().getInt("Playerdata." + uuid + ".CasesOwned.Epic") + args[3].toString());
				core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
				sender.sendMessage(core.getPrefix() + ChatColor.LIGHT_PURPLE + args[3].toString() + " " + args[2].toString() + " Succesfully added to " + args[1].toString() + "'s Account");
			}	
			sender.sendMessage(core.getPrefix() + ChatColor.LIGHT_PURPLE + "Please enter a specific amount!");
			return;
		}
		
		if(args[2].equals("legendary")) {
			if(!(args[3] == null)) {
				core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".CasesOwned.Legendary", core.getConfigs().getPlayerData().getInt("Playerdata." + uuid + ".CasesOwned.Legendary") + args[3].toString());
				core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
				sender.sendMessage(core.getPrefix() + ChatColor.LIGHT_PURPLE + args[3].toString() + " " + args[2].toString() + " Succesfully added to " + args[1].toString() + "'s Account");
			}
			sender.sendMessage(core.getPrefix() + ChatColor.LIGHT_PURPLE + "Please enter a specific amount!");
			return;
		}
		
	}

}
