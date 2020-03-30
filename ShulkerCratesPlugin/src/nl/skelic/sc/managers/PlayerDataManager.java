package nl.skelic.sc.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import nl.skelic.sc.Core;
import nl.skelic.sc.objects.PlayerData;

public class PlayerDataManager {
	
	private Core core;
	
	private List<PlayerData> players = new ArrayList<PlayerData>();
	
	public PlayerDataManager(Core core) {
		this.core = core;
	}
	
	public PlayerData getPlayerData(UUID uuid) {
		for(PlayerData playerData : players) {
			if(playerData.getUuid() == uuid) return playerData;
		}
		return null;
	}
	
	public List<PlayerData> getPlayers() {
		return players;
	}
}
