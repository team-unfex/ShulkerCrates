package nl.skelic.sc.configs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import nl.skelic.sc.Core;

public class ShulkerCratesConfiguration {
	
	private Core core;
	private File configFile;
	private File langFile;
	private YamlConfiguration config;
	private YamlConfiguration lang;
	
	public ShulkerCratesConfiguration(Core core) {
		this.core = core;
		configFile = new File(core.getDataFolder(), "config.yml");
		langFile = new File(core.getDataFolder(), "lang.yml");
		//generateConfig();
		generateLang();
	}
	
	void generateConfig() {
		core.saveDefaultConfig();
		if (!configFile.exists()) {
			try (InputStream is = core.getResource("config.yml"); 
			OutputStream os = new FileOutputStream(configFile)) {
				int readBytes;
				byte[] buffer = new byte[4096];
				while ((readBytes = is.read(buffer)) > 0) {
					os.write(buffer, 0, readBytes);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		config = YamlConfiguration.loadConfiguration(configFile);
		Bukkit.getConsoleSender().sendMessage(core.getPrefix() + ChatColor.GREEN + "Generated Config File!");
	}
	
	void generateLang() {
		core.saveDefaultConfig();
		if (!langFile.exists()) {
			try (InputStream is = core.getResource("lang.yml"); 
			OutputStream os = new FileOutputStream(langFile)) {
				int readBytes;
				byte[] buffer = new byte[4096];
				while ((readBytes = is.read(buffer)) > 0) {
					os.write(buffer, 0, readBytes);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		lang = YamlConfiguration.loadConfiguration(langFile);
		Bukkit.getConsoleSender().sendMessage(core.getPrefix() + ChatColor.GREEN + "Generated Lang File!");
	}
}
