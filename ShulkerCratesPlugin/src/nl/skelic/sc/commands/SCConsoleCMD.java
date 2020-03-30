package nl.skelic.sc.commands;

import org.bukkit.command.CommandSender;

public abstract class SCConsoleCMD {
	
	private String name;
	private String usage;
	private String description;
	private String permission;
	
	public SCConsoleCMD(String name, String usage, String description, String permission) {
		this.name = name;
		this.usage = usage;
		this.description = description;
		this.permission = permission;
	}
	
	abstract void run(CommandSender sender, String[] args);
	
	public String getName() {
		return name;
	}
	
	public String getUsage() {
		return usage;
	}

	public String getDescription() {
		return description;
	}
	
	public String getPermission() {
		return permission;
	}
}
