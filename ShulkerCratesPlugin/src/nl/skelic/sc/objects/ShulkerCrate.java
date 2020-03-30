package nl.skelic.sc.objects;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;

import nl.skelic.sc.Core;
import nl.skelic.sc.holograms.SCHolo;
import nl.skelic.sc.utils.Util;

public class ShulkerCrate {
	
	private Core core;
	
	private World world;
	private int x;
	private int y;
	private int z;
	
	private int id;
	private SCHolo scHolo;
	private List<ArmorStand> holo;
	
	public ShulkerCrate(Core core, int id, World world, int x, int y, int z) {
		this.id = id;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.holo = new ArrayList<ArmorStand>();
		this.core = core;
		
		summon();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public SCHolo getSCHolo() {
		return scHolo;
	}
	
	public void setSCHolo(SCHolo scHolo) {
		this.scHolo = scHolo;
	}
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public List<ArmorStand> getHolograms() {
		return holo;
	}
	
	public void summon() {
		String BoxColor = core.getConfigs().getConfig().getString("ShulkerCrates.BoxColor").toUpperCase().replaceAll(" ", "_");
		
		
		Location location = Util.formatLocation(world, x, y, z);
		
		//if (BoxColor.contains(" ")) {
		location.getBlock().setType(Material.getMaterial(BoxColor + "_SHULKER_BOX"));
	}
	
	public void remove() {
		Location location = Util.formatLocation(world, x, y, z);
		location.getBlock().setType(Material.AIR);
	}

}
