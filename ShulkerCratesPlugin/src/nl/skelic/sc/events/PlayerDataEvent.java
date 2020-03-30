package nl.skelic.sc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import nl.skelic.sc.Core;
import nl.skelic.sc.objects.PlayerData;

public class PlayerDataEvent implements Listener {

	private Core core;
	
	public PlayerDataEvent(Core core) {
		this.core = core;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = (Player) e.getPlayer();
		
		if (!core.getConfigs().getPlayerData().contains("Playerdata." + p.getUniqueId())) {
			// Cases Owned
			core.getConfigs().getPlayerData().set("Playerdata." + p.getUniqueId() + ".CasesOwned.Common", 0);
			core.getConfigs().getPlayerData().set("Playerdata." + p.getUniqueId() + ".CasesOwned.UnCommon", 0);
			core.getConfigs().getPlayerData().set("Playerdata." + p.getUniqueId() + ".CasesOwned.Rare", 0);
			core.getConfigs().getPlayerData().set("Playerdata." + p.getUniqueId() + ".CasesOwned.Epic", 0);
			core.getConfigs().getPlayerData().set("Playerdata." + p.getUniqueId() + ".CasesOwned.Legendary", 0);
			
			// Keys Owned
			core.getConfigs().getPlayerData().set("Playerdata." + p.getUniqueId() + ".KeysOwned.Common", 0);
			core.getConfigs().getPlayerData().set("Playerdata." + p.getUniqueId() + ".KeysOwned.UnCommon", 0);
			core.getConfigs().getPlayerData().set("Playerdata." + p.getUniqueId() + ".KeysOwned.Rare", 0);
			core.getConfigs().getPlayerData().set("Playerdata." + p.getUniqueId() + ".KeysOwned.Epic", 0);
			core.getConfigs().getPlayerData().set("Playerdata." + p.getUniqueId() + ".KeysOwned.Legendary", 0);
			
			core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
		}
		
		int commonCrates = core.getConfigs().getPlayerData().getInt("Playerdata." + p.getUniqueId() + ".CasesOwned.Common");
		int uncommonCrates = core.getConfigs().getPlayerData().getInt("Playerdata." + p.getUniqueId() + ".CasesOwned.UnCommon");
		int rareCrates = core.getConfigs().getPlayerData().getInt("Playerdata." + p.getUniqueId() + ".CasesOwned.Rare");
		int epicCrates = core.getConfigs().getPlayerData().getInt("Playerdata." + p.getUniqueId() + ".CasesOwned.Epic");
		int legendaryCrates = core.getConfigs().getPlayerData().getInt("Playerdata." + p.getUniqueId() + ".CasesOwned.Legendary");
		int commonKeys = core.getConfigs().getPlayerData().getInt("Playerdata." + p.getUniqueId() + ".KeysOwned.Common");
		int uncommonKeys = core.getConfigs().getPlayerData().getInt("Playerdata." + p.getUniqueId() + ".KeysOwned.UnCommon");
		int rareKeys = core.getConfigs().getPlayerData().getInt("Playerdata." + p.getUniqueId() + ".KeysOwned.Rare");
		int epicKeys = core.getConfigs().getPlayerData().getInt("Playerdata." + p.getUniqueId() + ".KeysOwned.Epic");
		int legendaryKeys = core.getConfigs().getPlayerData().getInt("Playerdata." + p.getUniqueId() + ".KeysOwned.Legendary");
		
		core.getPlayerDataManager().getPlayers().add(new PlayerData(p.getUniqueId(), commonCrates, uncommonCrates, rareCrates, epicCrates, legendaryCrates,
				commonKeys, uncommonKeys, rareKeys, epicKeys, legendaryKeys, core));
		
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		core.getPlayerDataManager().getPlayers().remove(core.getPlayerDataManager().getPlayerData(e.getPlayer().getUniqueId()));
	}
	
}
