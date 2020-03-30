package nl.skelic.sc;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;
import nl.skelic.lib.gui.listeners.MenuListeners;
import nl.skelic.sc.commands.ShulkerCratesCMD;
import nl.skelic.sc.configs.Configs;
import nl.skelic.sc.configs.ShulkerCratesConfiguration;
import nl.skelic.sc.events.PlayerDataEvent;
import nl.skelic.sc.events.RightClickArmorStandEvent;
import nl.skelic.sc.events.RightClickCrateEvent;
import nl.skelic.sc.holograms.SCHolo;
import nl.skelic.sc.managers.HoloManager;
import nl.skelic.sc.managers.PlaceholderManager;
import nl.skelic.sc.managers.PlayerDataManager;
import nl.skelic.sc.managers.ShulkerManager;
import nl.skelic.sc.menus.OpenCrateMenu;
import nl.skelic.sc.mysql.SCMySQL;
import nl.skelic.sc.utils.Util;

public class Core extends JavaPlugin {
	
	private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
	
	private PluginManager pm; /* Wordt later nog gebruikt. */
	private ShulkerManager shulkerManager;
	private SCHolo scHolo;
	private HoloManager holoManager;
	private PlayerDataManager playerDataManager;
	
	private Configs configs;
	//private ShulkerCratesConfiguration shulkerCratesConfiguration;
	
	private Util util;
	
	private SCMySQL mysql;
	
	private String prefix;
	
	private OpenCrateMenu openCrateMenu;
	//private String crateName;
	
	@Override
	public void onEnable() {
		prefix = ChatColor.LIGHT_PURPLE + "[ShulkerCrates]" + ChatColor.RESET + " ";
		
		// Loading Settings
		pm = Bukkit.getServer().getPluginManager();
//		GuiAPI.setPluginInstance(this);
		
		// Requirements
		requirements();
		
		// Loading Folders
		if (new File(getDataFolder(), "Data").mkdirs()) Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GREEN + "Generated Crates folder!");
				
		loadConfig();
		
		// Loadin Utils
		util = new Util(this);
		
		// Register
		register();
		
		// Loading Database
		//mysql.setup();
		
		// Managers
		//scHolo = new SCHolo(this);
		holoManager = new HoloManager(this);
		shulkerManager = new ShulkerManager(this);
		playerDataManager = new PlayerDataManager(this);
		
		// Loads the shulkercrates
		getShulkerManager().loadCrates();
		//getShulkerManager().summonSCrates();
		getHoloManager().summonSCHolograms();
		// Version detection
		/*getLogger().severe("[ShulkerCrates] Checking for Updates...");
		if (upd.updateCheck()) {
			Bukkit.getPluginManager().disablePlugin(this);
			getLogger().severe("[ShulkerCrates] The plugins has been updates, the server is reloading...");
			Bukkit.getPluginManager().loadPlugin(new File("./plugins/ShulkerCrates.jar"));
		} else {*/
			// Finished Message
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "-------{ShulkerCrates Plugin}-------");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "|" + ChatColor.LIGHT_PURPLE + "     Created by: Team UnFex      " + ChatColor.DARK_PURPLE + "|");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "|" + ChatColor.LIGHT_PURPLE + "                 (SKELIC, Unusual) " + ChatColor.DARK_PURPLE + "|");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "|" + ChatColor.LIGHT_PURPLE + "           Version: v" + getDescription().getVersion() + "          " + ChatColor.DARK_PURPLE + "|");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "|" + ChatColor.LIGHT_PURPLE + "      Plugin Status: " + ChatColor.GREEN + "Enabled      " + ChatColor.DARK_PURPLE + "|");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "------------------------------------");
		//}
	}

	private void requirements() {
		if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
		
		if( Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            new PlaceholderManager().register();
        }
	}

	@Override
	public void onDisable() {
		getShulkerManager().removeSCrates();
		getHoloManager().removeSCHolograms();
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "|" + ChatColor.LIGHT_PURPLE + "     Created by: Team UnFex      " + ChatColor.DARK_PURPLE + "|");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "|" + ChatColor.LIGHT_PURPLE + "                 (SKELIC, Unusual) " + ChatColor.DARK_PURPLE + "|");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "|" + ChatColor.LIGHT_PURPLE + "           Version: v" + getDescription().getVersion() + "          " + ChatColor.DARK_PURPLE + "|");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "|" + ChatColor.LIGHT_PURPLE + "      Plugin Status: " + ChatColor.RED + "Disabled     " + ChatColor.DARK_PURPLE + "|");
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "------------------------------------");
	}
	
	private void register() {
		// Commands
		getCommand("shulkercrates").setExecutor(new ShulkerCratesCMD(this));
		
		// Event
		pm.registerEvents(new RightClickCrateEvent(this), this);
		pm.registerEvents(new RightClickArmorStandEvent(this), this);
		pm.registerEvents(new PlayerDataEvent(this), this);
		pm.registerEvents(new MenuListeners(), this);
		
		// Menus
		//cratesMenu = new CratesMenu(this);
	}

	private void loadConfig() {
		// Loading Configs
		if (!new File(getDataFolder(), "config.yml").exists()) saveDefaultConfig();
		//if (!new File(getDataFolder(), "lang.yml").exists()) saveDefaultConfig();
		new ShulkerCratesConfiguration(this);
		configs = new Configs(this);
		getConfigs().create(getDataFolder() + File.separator + "Data" + File.separator, "crates");
		getConfigs().create(getDataFolder() + File.separator + "Data" + File.separator, "playerdata");
		
	}
	
	/*private void createFiles() {
		getConfigs().create(getDataFolder() + File.separator + "Data" + File.separator, "crates");
		getConfigs().getCrates().addDefault("Crates", "");
		getConfigs().create(getDataFolder() + File.separator + "Data" + File.separator, "playerdata");
		
		File crateFile = new File(getDataFolder() + File.separator + "Data" + File.separator, "crates.yml");
		if (!crateFile.exists()) {
			try {
				crateFile.createNewFile();
				Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GREEN + "Generated Data File!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File playerdataFile = new File(getDataFolder() + File.separator + "Data" + File.separator, "playerdata.yml");
		if (!playerdataFile.exists()) {
			try {
				playerdataFile.createNewFile();
				Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GREEN + "Generated playerdata File!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}*/
	
//	public OpenCrateMenu getOpenCrateMenu(String crateName, Player player) {
//		openCrateMenu = new OpenCrateMenu(this, player, crateName);
//		return openCrateMenu;
//	}
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
	
	public static Economy getEconomy() {
        return econ;
    }
	
	public String getPrefix() {
		return prefix;
	}
	
	public Configs getConfigs() {
		return configs;
	}
	
	public ShulkerManager getShulkerManager() {
		return shulkerManager;
	}
	
	public PlayerDataManager getPlayerDataManager() {
		return playerDataManager;
	}
	
	public HoloManager getHoloManager() {
		return holoManager;
	}
	
	public SCHolo getHolograms() {
		return scHolo;
	}

	public Util getUtil() {
		return util;
	}
	
}
