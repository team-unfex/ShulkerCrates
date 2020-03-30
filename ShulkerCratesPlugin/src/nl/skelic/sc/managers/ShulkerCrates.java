package nl.skelic.sc.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import nl.skelic.sc.Core;
import nl.skelic.sc.effects.FireworksEffects;
import nl.skelic.sc.holograms.SCHolo;
import nl.skelic.sc.objects.ShulkerCrate;

public class ShulkerCrates {
	
	private Core core;
	
	private final FireworksEffects fireworksEffect = FireworksEffects.getFireworksEffects();
	
	private World world;
	private Location loc;
	private SCHolo scHolo;
	private List<ArmorStand> holo;
	
	public ShulkerCrates(Core core, World world, Location loc) {
		this.core = core;
		this.world = world;
		this.loc = loc;
		this.holo = new ArrayList();
	}
	
	public Location getLoc() {
		return loc.clone();
	}
	
	public void openCrate(String crateName, Player player, ShulkerCrate shulkerCrate) {
		ShulkerCrate crate = shulkerCrate;
		
		if (crateName == "Common") {
			
			
			
			return;
		}
	}
	
}
