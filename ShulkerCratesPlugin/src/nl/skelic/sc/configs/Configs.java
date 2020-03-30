package nl.skelic.sc.configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import nl.skelic.sc.Core;

public class Configs {
	
	public Core core;
	
	private File configFile;
	private FileConfiguration config;
	
	private	File langFile;
	private FileConfiguration lang;
	
	private	File cratesFile;
	private FileConfiguration crates;
	
	private File playerdataFile;
	private FileConfiguration playerdata;
	
	private	File customFile;
	private FileConfiguration custom;
	
	public Configs(Core core) {
		configFile = new File(core.getDataFolder(), "config.yml");
		config = YamlConfiguration.loadConfiguration(configFile);
		cratesFile = new File(core.getDataFolder() + File.separator + "Data", "crates.yml");
		crates = YamlConfiguration.loadConfiguration(cratesFile);
		playerdataFile = new File(core.getDataFolder() + File.separator + "Data", "playerdata.yml");
		playerdata = YamlConfiguration.loadConfiguration(playerdataFile);
		langFile = new File(core.getDataFolder(), "lang.yml");
		lang = YamlConfiguration.loadConfiguration(langFile);
		this.core = core;
	}
	
	public void save(FileConfiguration config, File file) {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void create(String directory, String file) {
		File customFile = new File(directory, file + ".yml");
		if (!customFile.exists()) {
			try {
				customFile.createNewFile();
				Bukkit.getConsoleSender().sendMessage(core.getPrefix() + ChatColor.GREEN + "Generated " + file + "File!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void load(String file) {
		try {
			File customFile = new File(core.getDataFolder(), file + ".yml");
			YamlConfiguration customFileConfig = YamlConfiguration.loadConfiguration(customFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String color(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
	public File getConfigFile() {
		return configFile;
	}
	
	public FileConfiguration getConfig() {
		return config;
	}
	
	public File getLangFile() {
		return langFile;
	}
	
	public FileConfiguration getLang() {
		return lang;
	}
	
	public File getCratesFile() {
		return cratesFile;
	}
	
	public FileConfiguration getCrates() {
		return crates;
	}
	
	public File getPlayerDataFile() {
		return playerdataFile;
	}
	
	public FileConfiguration getPlayerData() {
		return playerdata;
	}
	
}
