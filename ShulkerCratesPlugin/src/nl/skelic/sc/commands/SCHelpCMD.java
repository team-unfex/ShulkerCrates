package nl.skelic.sc.commands;

import java.util.Iterator;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import nl.skelic.sc.Core;

public class SCHelpCMD extends SCDefaultCMD {
	
	private ShulkerCratesCMD executor;
	
	public SCHelpCMD(ShulkerCratesCMD executor, Core core) {
		super("Help", "/shulkercrates help", core.getConfigs().getLang().getString("commands.sc-help"), "shulkercrates.help");
		this.executor = executor;
	}
	
	@Override
	public void run(Player p, String[] args) {
		Set<SCDefaultCMD> commands = executor.getCommands();
		Iterator<SCDefaultCMD> commandsIterator = commands.iterator();
		
		p.sendMessage(ChatColor.GRAY + "-==========- " + ChatColor.LIGHT_PURPLE + "ShulkerCrates" + ChatColor.GRAY + " -==========-");
		while (commandsIterator.hasNext()) {
			SCDefaultCMD command = commandsIterator.next();
			p.sendMessage(ChatColor.DARK_PURPLE + command.getUsage() + ChatColor.GRAY + " - " + command.getDescription());
		}
		for(SCConsoleCMD command : executor.getConsoleCommands()) {
			p.sendMessage(ChatColor.DARK_PURPLE + command.getUsage() + ChatColor.GRAY + " - " + command.getDescription());
		}
		p.sendMessage(ChatColor.GRAY + "-===================================-");
	}
	
}
