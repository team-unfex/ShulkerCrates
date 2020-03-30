package nl.skelic.sc.holograms;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.PlaceholderAPI;
import net.minecraft.server.v1_13_R2.EntityLiving;
import net.minecraft.server.v1_13_R2.PacketPlayOutSpawnEntityLiving;
import nl.skelic.sc.Core;
import nl.skelic.sc.objects.ShulkerCrate;
import nl.skelic.sc.utils.Util;

public class SCHolo {
	
	private Core core;
	
	private World world;
	private double x;
	private double y;
	private double z;
	
	private ShulkerCrate sc;
	private ArmorStand asL1;
	private ArmorStand asL2;
	private ArmorStand asL3;
	
	private Player p;
	
	public SCHolo(Core core, World world, double x, double y, double z, ShulkerCrate sc) {
		this.world = world;
		this.sc = sc;
		this.x = x;
		this.y = y;
		this.z = z;
		this.core = core;
		sc.setSCHolo(this);
		summon();
	}
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public ShulkerCrate getSC() {
		return sc;
	}
	
	public ArmorStand getASL1() {
		return asL1;
	}
	
	public ArmorStand getASL2() {
		return asL2;
	}

	public ArmorStand getASL3() {
		return asL3;
	}

	private void summon() {
		if (asL1 != null) asL1.remove();
		if (asL2 != null) asL2.remove();
		if (asL3 != null) asL3.remove();
		
		String firstLine = Util.color(core.getConfigs().getConfig().getString("ShulkerCrates.Holograms.First-Line"));
		String secondLine = Util.color(core.getConfigs().getConfig().getString("ShulkerCrates.Holograms.Second-Line"));
		String thirdLine = Util.color(core.getConfigs().getConfig().getString("ShulkerCrates.Holograms.Third-Line"));
		
		Location loc = Util.formatLocation(world, x, y, z);
		
		asL1 = ((ArmorStand) world.spawnEntity(loc, EntityType.ARMOR_STAND));
		asL2 = ((ArmorStand) world.spawnEntity(loc.clone().subtract(0.0D, 0.25D, 0.0D), EntityType.ARMOR_STAND));
		asL3 = ((ArmorStand) world.spawnEntity(loc.clone().subtract(0.0D, 0.5D, 0.0D), EntityType.ARMOR_STAND));
		
		asL1.setMarker(true); asL2.setMarker(true); asL3.setMarker(true);
		asL1.setGravity(false); asL2.setGravity(false); asL3.setGravity(false);
		asL1.setCanPickupItems(false); asL2.setCanPickupItems(false); asL3.setCanPickupItems(false);
		asL1.setCustomNameVisible(true); asL2.setCustomNameVisible(true); asL3.setCustomNameVisible(true);
		asL1.setVisible(false); asL2.setVisible(false); asL3.setVisible(false);
		
		asL1.setCustomName(firstLine);
		asL2.setCustomName(secondLine);
		asL3.setCustomName(thirdLine);
	}
	
	/*public void createHolo (World world, Location loc) {
		Location as1loc = loc.add(0, core.getConfigs().getConfig().getDouble("ShulkerCrates.Holograms.Height"), 0);
		Location as2loc = loc.add(0, core.getConfigs().getConfig().getDouble("ShulkerCrates.Holograms.Height") + .25, 0);
		Location as3loc = loc.add(0, core.getConfigs().getConfig().getDouble("ShulkerCrates.Holograms.Height") + .5, 0);
		ArmorStand asL1 = (ArmorStand) world.spawnEntity(as1loc, EntityType.ARMOR_STAND);
		ArmorStand asL2 = (ArmorStand) world.spawnEntity(as2loc, EntityType.ARMOR_STAND);
		ArmorStand asL3 = (ArmorStand) world.spawnEntity(as3loc, EntityType.ARMOR_STAND);
		
		asL1.setGravity(false); asL2.setGravity(false); asL3.setGravity(false);
		asL1.setCanPickupItems(false); asL2.setCanPickupItems(false); asL3.setCanPickupItems(false);
		asL1.setCustomNameVisible(false); asL2.setCustomNameVisible(false); asL3.setCustomNameVisible(false);
		asL1.setVisible(false); asL2.setVisible(false); asL3.setVisible(false);
		
		asL1.setCustomName(Util.color(core.getConfigs().getConfig().getString("ShulkerCrates.Holograms.First-Line")));
		asL2.setCustomName(Util.color(core.getConfigs().getConfig().getString("ShulkerCrates.Holograms.Second-Line")));
		asL3.setCustomName(Util.color(core.getConfigs().getConfig().getString("ShulkerCrates.Holograms.Third-Line")));
	}*/
	
	public void remove() {
		asL1.remove();
		asL2.remove();
		asL3.remove();
	}
	
}
