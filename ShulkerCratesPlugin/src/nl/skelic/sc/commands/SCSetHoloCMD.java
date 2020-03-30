package nl.skelic.sc.commands;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import nl.skelic.sc.Core;

public class SCSetHoloCMD extends SCDefaultCMD {
	
	private Core core;
	
	private ShulkerCratesCMD executor;
	
	public SCSetHoloCMD(ShulkerCratesCMD executor, Core core) {
		super("SetHolo", "/shulkercrates setholo <First-Line> <Second-Line> <Third-Line>", core.getConfigs().getLang().getString("commands.sc-setholo"), "shulkercrates.setholo");
		this.executor = executor;
	}
	
	@Override
	void run(Player p, String[] args) {
		if (args.length < 3) {
			p.sendMessage(core.getPrefix() + ChatColor.RED + core.getConfigs().getLang().getString("errors.wrong-commands") + " /shulkercrates setholo <First-Line> <Second-Line> <Third-Line>");
			return;
		}
		
		core.getConfigs().getConfig().set("ShulkerCrates.Holograms.First-Line", args[1]);
		core.getConfigs().getConfig().set("ShulkerCrates.Holograms.Second-Line", args[2]);
		core.getConfigs().getConfig().set("ShulkerCrates.Holograms.Third-Line", args[3]);
		core.getConfigs().save(core.getConfigs().getConfig(), core.getConfigs().getConfigFile());
		
		p.sendMessage(core.getPrefix() + ChatColor.GREEN + "First-Line changed in " + args[1]);
		p.sendMessage(core.getPrefix() + ChatColor.GREEN + "Second-Line changed in " + args[2]);
		p.sendMessage(core.getPrefix() + ChatColor.GREEN + "Third-Line changed in " + args[3]);
	}
	
}
