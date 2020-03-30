package nl.skelic.sc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import nl.skelic.sc.Core;
import nl.skelic.sc.configs.Configs;

public class SCMySQL {
	
	private Core core;
	private Connection connection;
	public String host, database, username, password;
	public int port;
	public boolean enabled;
	
	public void setup() {
		host = core.getConfigs().getConfig().getString("MySQL.Host");
		port = core.getConfigs().getConfig().getInt("MySQL.Port");
		database = core.getConfigs().getConfig().getString("MySQL.Database");
		username = core.getConfigs().getConfig().getString("MySQL.Username");
		password = core.getConfigs().getConfig().getString("MySQL.Password");
		enabled = core.getConfigs().getConfig().getBoolean("MySQL.Enabled");
		
		if (!enabled == true) {
			Bukkit.broadcastMessage(core.getPrefix() + "The MySQL Databse is Disabled!");
			return;
		}
		
		Bukkit.broadcastMessage(core.getPrefix() + "The MySQL Databse is Enabled!");
		
		BukkitRunnable r = new BukkitRunnable() {
			@Override
			public void run() {
				try {
					openConnection();
					Statement stat = connection.createStatement();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		};
		
		r.runTaskAsynchronously(core);
	}

	private void openConnection() throws SQLException, ClassNotFoundException {
		if (connection != null && !connection.isClosed()) {
			return;
		}
		
		synchronized (this) {
			if (connection != null && !connection.isClosed()) {
				return;
			}
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?autoReconnect=true&user=" + this.username + "&password=" + this.password + "");
		}
	}
	
	public void updateTable(String query) {
		try {
			PreparedStatement pStat = connection.prepareStatement(query);
			pStat.execute();
			pStat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
