package nl.skelic.sc.commands;

import java.util.LinkedHashSet;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.skelic.sc.Core;
import nl.skelic.sc.utils.MsgUtil;
import nl.skelic.sc.utils.Util;

public class ShulkerCratesCMD implements CommandExecutor {
	
	private Core core;
	private Set<SCDefaultCMD> cmds = new LinkedHashSet<SCDefaultCMD>();
	private Set<SCConsoleCMD> consolecmds = new LinkedHashSet<SCConsoleCMD>();
	
	public ShulkerCratesCMD(Core core) {
		this.core = core;
		cmds.add(new SCHelpCMD(this, core));
		cmds.add(new SCCreateCMD(this, core));
		cmds.add(new SCRemoveCMD(this, core));
		cmds.add(new SCSetHoloCMD(this, core));
		cmds.add(new SCListCMD(this, core));
		
		consolecmds.add(new SCAddCrateCMD(this, core));
		
		//consolecmds.add(new SCAddCrateCMD(this, core));
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(Util.color(core.getConfigs().getLang().getString("errors.errors.player-only")));
			return true;
		} 
		
		Player p = (Player) sender;
		
		if (args.length == 0) {
			sender.sendMessage(ChatColor.GRAY + "-==========- " + ChatColor.LIGHT_PURPLE + "ShulkerCrates" + ChatColor.GRAY + " -==========-");
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "Version: " + core.getDescription().getVersion());
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "by Team UnFex(SKELIC & Unsu4l)");
			sender.sendMessage(" ");
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "/shulkercrates help " + ChatColor.GRAY + " to view all the commands.");
			sender.sendMessage(ChatColor.GRAY + "-====================================-");
			return true;
		}
		
		for(SCConsoleCMD cmd : consolecmds) {
			if(cmd.getName().equalsIgnoreCase(args[0])) {
		    	
                if(cmd.getPermission() == null) {
                	cmd.run(p, args);
                    return false;
                }
                
                if(!p.hasPermission(cmd.getPermission())) {
                    p.sendMessage(Util.color(core.getConfigs().getLang().getString("errors.no-permissions")));
                    return false;
                }
                
                cmd.run(p, args);
		    }
		}
		
		for(SCDefaultCMD cmd : cmds) {
			
		    if(cmd.getName().equalsIgnoreCase(args[0])) {
		    	
                if(cmd.getPermission() == null) {
                	cmd.run(p, args);
                    return false;
                }
                
                if(!p.hasPermission(cmd.getPermission())) {
                    p.sendMessage(Util.color(core.getConfigs().getLang().getString("errors.no-permissions")));
                    return false;
                }
                
                cmd.run(p, args);
		    }
		}
		
		return false;
	}
	
	public Set<SCDefaultCMD> getCommands() {
		return cmds;
	}

	public Set<SCConsoleCMD> getConsoleCommands() {
		return consolecmds = new LinkedHashSet<SCConsoleCMD>();
	}
	
	
	/*@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(MsgUtil.NOTPLR.getMessage());
			return false;
		} else {
		if (args.length < 1) {
			sender.sendMessage(ChatColor.GRAY + "-==========- " + ChatColor.LIGHT_PURPLE + "ShulkerCrates" + ChatColor.GRAY + " -==========-");
			sender.sendMessage(ChatColor.DARK_PURPLE + "/shulkercrates help" + ChatColor.GRAY + " - " + Configs.getConfigs().color(Configs.getConfigs().getLang().getString("commands.sc-help")));
			sender.sendMessage(ChatColor.DARK_PURPLE + "/shulkercrates create" + ChatColor.GRAY + " - " + Configs.getConfigs().color(Configs.getConfigs().getLang().getString("commands.sc-add")));
			sender.sendMessage(ChatColor.DARK_PURPLE + "/shulkercrates remove" + ChatColor.GRAY + " - " + Configs.getConfigs().color(Configs.getConfigs().getLang().getString("commands.sc-remove")));
			sender.sendMessage(ChatColor.DARK_PURPLE + "/shulkercrates setholo <First-Line> <Second-Line> <Third-Line>" + ChatColor.GRAY + " - " + Configs.getConfigs().color(Configs.getConfigs().getLang().getString("commands.sc-setholo")));
			sender.sendMessage(ChatColor.DARK_PURPLE + "/shulkercrates list" + ChatColor.GRAY + " - " + Configs.getConfigs().color(Configs.getConfigs().getLang().getString("commands.sc-list")));
			sender.sendMessage(ChatColor.GRAY + "-===================================-");
			return false;
		} else {
			if (args[0].equalsIgnoreCase("help")) {
				sender.sendMessage(ChatColor.GRAY + "-==========- " + ChatColor.LIGHT_PURPLE + "ShulkerCrates" + ChatColor.GRAY + " -==========-");
				sender.sendMessage(ChatColor.DARK_PURPLE + "/shulkercrates help" + ChatColor.GRAY + " - " + Configs.getConfigs().color(Configs.getConfigs().getLang().getString("commands.sc-help")));
				sender.sendMessage(ChatColor.DARK_PURPLE + "/shulkercrates create" + ChatColor.GRAY + " - " + Configs.getConfigs().color(Configs.getConfigs().getLang().getString("commands.sc-add")));
				sender.sendMessage(ChatColor.DARK_PURPLE + "/shulkercrates remove" + ChatColor.GRAY + " - " + Configs.getConfigs().color(Configs.getConfigs().getLang().getString("commands.sc-remove")));
				sender.sendMessage(ChatColor.DARK_PURPLE + "/shulkercrates setholo <First-Line> <Second-Line> <Third-Line>" + ChatColor.GRAY + " - " + Configs.getConfigs().color(Configs.getConfigs().getLang().getString("commands.sc-setholo")));
				sender.sendMessage(ChatColor.DARK_PURPLE + "/shulkercrates list" + ChatColor.GRAY + " - " + Configs.getConfigs().color(Configs.getConfigs().getLang().getString("commands.sc-list")));
				sender.sendMessage(ChatColor.GRAY + "-===================================-");
				return false;
			}
			
			Player p = (Player) sender;
			Block tBlock = p.getTargetBlock((Set<Material>)null, 10);
			Location pLoc = p.getLocation();
			File cFolder = new File(plugin.getDataFolder() + File.separator + "Crates" + File.separator);
			File[] cList = cFolder.listFiles();
			
			if (args[0].equalsIgnoreCase("create")) {
				if (sender.hasPermission("ShulkerCrates.create")) {
					if (!tBlock.getType().equals(Material.SHULKER_BOX)) {
						sender.sendMessage(Util.prefix + ChatColor.RED + "The block you looking at is not a Shulker Box");
						return false;
					} else {
						Location loc = tBlock.getLocation();
									File crateDataFile = new File(plugin.getDataFolder() + File.separator + "Crates" + File.separator, "CratesData" + cList.length + ".yml");
									if (!crateDataFile.exists()) {
										try {
											crateDataFile.createNewFile();
											Bukkit.getConsoleSender().sendMessage(Util.prefix + ChatColor.GOLD + Configs.getConfigs().getLang().getString("messages.crate.scdata-creating") + " " + crateDataFile.getName());
										} catch (IOException e) {
											e.printStackTrace();
										}
									} else {
										sender.sendMessage(Util.prefix + ChatColor.RED + crateDataFile.getName() + " " + Configs.getConfigs().getLang().getString("messages.exists"));
										return false;
									}
									
					
									YamlConfiguration crateDataConfig = YamlConfiguration.loadConfiguration(crateDataFile);
									Bukkit.getConsoleSender().sendMessage(Util.prefix + ChatColor.GOLD + Configs.getConfigs().getLang().getString("messages.crates.scdata-loading") + " " + crateDataFile.getName());
								
									if (!crateDataConfig.contains("Coordinates")) {
										crateDataConfig.set("Coordinates", loc.getX() + "," + loc.getY() + "," + loc.getZ());
										Bukkit.getConsoleSender().sendMessage(Util.prefix + ChatColor.GOLD + Configs.getConfigs().getLang().getString("messages.variables.cords") + " " + crateDataFile.getName());
									}
					
									util.saveFile(crateDataConfig, crateDataFile);
									if (!crateDataConfig.contains("Owner")) {
										crateDataConfig.set("Owner", p.getName().toString());
										Bukkit.getConsoleSender().sendMessage(Util.prefix + ChatColor.GOLD + Configs.getConfigs().getLang().getString("messages.variables.owner") + " " + crateDataFile.getName());
									}
					
									util.saveFile(crateDataConfig, crateDataFile);
									Bukkit.getConsoleSender().sendMessage(Util.prefix + ChatColor.GOLD + Configs.getConfigs().getLang().getString("messages.crates.scdata-saving") + " " + crateDataFile.getName());
									sender.sendMessage(Util.prefix + ChatColor.GREEN + crateDataFile.getName() + " " + Configs.getConfigs().getLang().getString("messages.succes-created"));
									
									loc.getBlock().setType(Material.WHITE_SHULKER_BOX);
									p.playSound(pLoc, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
									//return false;
						return false;
					}
				}
			} else {
				sender.sendMessage(MsgUtil.NOPERM.getMessage());
				return false;
			}
		}
		return false;
		}
	}*/
	
}
