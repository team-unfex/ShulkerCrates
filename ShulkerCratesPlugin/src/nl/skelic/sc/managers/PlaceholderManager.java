package nl.skelic.sc.managers;

import org.bukkit.entity.Player;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import nl.skelic.sc.Core;

public class PlaceholderManager extends PlaceholderExpansion {

	@Override
	public String getAuthor() {
		return "UnFex";
	}

	@Override
	public String getIdentifier() {
		return "shulkercrates";
	}

	@Override
	public String getVersion() {
		return "1.0.0";
	}
	
	@Override
	public String getPlugin() {
		return null;
	}
	
	@Override
	public boolean persist() {
		return true;
	}
	
	public String onPlaceholderRequest(Core core, Player p, String id) {
		if (p == null) {
			return null;
		}
		
		int common = (int) core.getConfigs().getPlayerData().get("Playerdata." + p.getUniqueId() + ".CasesOwned.Common");
		int uncommon = (int) core.getConfigs().getPlayerData().get("Playerdata." + p.getUniqueId() + ".CasesOwned.UnCommon");
		int rare = (int) core.getConfigs().getPlayerData().get("Playerdata." + p.getUniqueId() + ".CasesOwned.Rare");
		int epic = (int) core.getConfigs().getPlayerData().get("Playerdata." + p.getUniqueId() + ".CasesOwned.Epic");
		int legendary = (int) core.getConfigs().getPlayerData().get("Playerdata." + p.getUniqueId() + ".CasesOwned.Legendary");
		
		int total = common + uncommon + rare + epic + legendary;
		
		/*switch (id) {
		case "crates_owned": 
			return String.valueOf(total);
		}*/
		if (id.equalsIgnoreCase("crates_owned")) {
			return String.valueOf(total);
		}
		return null;
	}

}
