package nl.skelic.sc.utils;

import org.bukkit.entity.Player;

import nl.skelic.sc.Core;

public class SCUtils {
	
	private Core core;
	private Player p;
	
	public String translatePlaceholders(Player player, String string) {
		if (player == null) {
			return string;
		}
		
		int common = (int) core.getConfigs().getPlayerData().get("Playerdata." + p.getUniqueId() + ".CasesOwned.Common");
		int unCommon = (int) core.getConfigs().getPlayerData().get("Playerdata." + p.getUniqueId() + ".CasesOwned.UnCommon");
		int rare = (int) core.getConfigs().getPlayerData().get("Playerdata." + p.getUniqueId() + ".CasesOwned.Rare");
		int epic = (int) core.getConfigs().getPlayerData().get("Playerdata." + p.getUniqueId() + ".CasesOwned.Epic");
		int legendary = (int) core.getConfigs().getPlayerData().get("Playerdata." + p.getUniqueId() + ".CasesOwned.Legendary");
		
		String owned = "" + common + unCommon + rare + epic + legendary;
		
		string = string.replaceAll("%CASES_OWNED%", owned);
		
		return string;
	}
}
