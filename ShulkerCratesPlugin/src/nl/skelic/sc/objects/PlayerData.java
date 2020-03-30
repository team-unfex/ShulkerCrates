package nl.skelic.sc.objects;

import java.util.UUID;

import nl.skelic.sc.Core;

public class PlayerData {
	
	private Core core;
	
	private UUID uuid;
	
	private int commonCrates;
	private int uncommonCrates;
	private int rareCrates;
	private int epicCrates;
	private int legendaryCrates;
	
	private int commonKeys;
	private int uncommonKeys;
	private int rareKeys;
	private int epicKeys;
	private int legendaryKeys;
	
	public PlayerData(UUID uuid, int commonCrates, int uncommonCrates, int rareCrates, int epicCrates, int legendaryCrates, int commonKeys, int uncommonKeys, int rareKeys, int epicKeys, int legendaryKeys, Core core) {
		this.commonCrates = commonCrates;
		this.uncommonCrates = uncommonCrates;
		this.rareCrates = rareCrates;
		this.epicCrates = epicCrates;
		this.legendaryCrates = legendaryCrates;
		this.commonKeys = commonKeys;
		this.uncommonKeys = uncommonKeys;
		this.rareKeys = rareKeys;
		this.epicKeys = epicKeys;
		this.legendaryKeys = legendaryKeys;
		this.uuid = uuid;
		this.core = core;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	/* Crates */

	public int getCommonCrates() {
		return commonCrates;
	}

	public void setCommonCrates(int commonCrates) {
		this.commonCrates = commonCrates;
		core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".CasesOwned.Common", commonCrates);
		core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
	}

	public int getUncommonCrates() {
		return uncommonCrates;
	}

	public void setUncommonCrates(int uncommonCrates) {
		this.uncommonCrates = uncommonCrates;
		core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".CasesOwned.UnCommon", uncommonCrates);
		core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
	}

	public int getRareCrates() {
		return rareCrates;
	}

	public void setRareCrates(int rareCrates) {
		this.rareCrates = rareCrates;
		core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".CasesOwned.Rare", rareCrates);
		core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
	}

	public int getEpicCrates() {
		return epicCrates;
	}

	public void setEpicCrates(int epicCrates) {
		this.epicCrates = epicCrates;
		core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".CasesOwned.Epic", epicCrates);
		core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
	}

	public int getLegendaryCrates() {
		return legendaryCrates;
	}

	public void setLegendaryCrates(int legendaryCrates) {
		this.legendaryCrates = legendaryCrates;
		core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".CasesOwned.Legendary", legendaryCrates);
		core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
	}

	/* Keys */
	
	public int getCommonKeys() {
		return commonKeys;
	}

	public void setCommonKeys(int commonKeys) {
		this.commonKeys = commonKeys;
		core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".KeysOwned.Common", commonKeys);
		core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
	}

	public int getUncommonKeys() {
		return uncommonKeys;
	}

	public void setUncommonKeys(int uncommonKeys) {
		this.uncommonKeys = uncommonKeys;
		core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".KeysOwned.UnCommon", uncommonKeys);
		core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
	}

	public int getRareKeys() {
		return rareKeys;
	}

	public void setRareKeys(int rareKeys) {
		this.rareKeys = rareKeys;
		core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".KeysOwned.Rare", rareKeys);
		core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
	}

	public int getEpicKeys() {
		return epicKeys;
	}

	public void setEpicKeys(int epicKeys) {
		this.epicKeys = epicKeys;
		core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".KeysOwned.Epic", epicKeys);
		core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
	}

	public int getLegendaryKeys() {
		return legendaryKeys;
	}

	public void setLegendaryKeys(int legendaryKeys) {
		this.legendaryKeys = legendaryKeys;
		core.getConfigs().getPlayerData().set("Playerdata." + uuid + ".KeysOwned.Legendary", legendaryKeys);
		core.getConfigs().save(core.getConfigs().getPlayerData(), core.getConfigs().getPlayerDataFile());
	}

	
	
}
