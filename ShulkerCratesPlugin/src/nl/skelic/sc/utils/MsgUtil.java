package nl.skelic.sc.utils;

import org.bukkit.ChatColor;

import nl.skelic.sc.Core;

public enum MsgUtil {
	NOPERM(Core.getPlugin(Core.class).getConfigs().color(Core.getPlugin(Core.class).getConfigs().getLang().getString("errors.no-permissions"))),
	NOTPLR(Core.getPlugin(Core.class).getConfigs().color(Core.getPlugin(Core.class).getConfigs().getLang().getString("errors.player-only"))),
	CMDNF(Core.getPlugin(Core.class).getConfigs().color(Core.getPlugin(Core.class).getConfigs().getLang().getString("errors.command-not-found"))),
	DEXISTS(Core.getPlugin(Core.class).getConfigs().color(Core.getPlugin(Core.class).getConfigs().getLang().getString("errors.dexist"))),
	EXISTS(Core.getPlugin(Core.class).getConfigs().color(Core.getPlugin(Core.class).getConfigs().getLang().getString("errors.exist"))),
	WRONGCMD(Core.getPlugin(Core.class).getConfigs().color(Core.getPlugin(Core.class).getConfigs().getLang().getString("errors.wrong-command")));
	
	private static MsgUtil msgU;
	
	private String message;
	
	MsgUtil(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String color(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
	public static MsgUtil MsgU() {
		return msgU;
	}
}