package nl.skelic.sc.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.ArmorStand;

import nl.skelic.sc.Core;
import nl.skelic.sc.holograms.SCHolo;
import nl.skelic.sc.objects.ShulkerCrate;


public class HoloManager {
	
	private Core core;
	
	private List<SCHolo> holograms = new ArrayList<SCHolo>();
	
	public HoloManager(Core core) {
		this.core = core;
	}
	
	public SCHolo getHologram(ArmorStand as) {
		for (SCHolo scHolo : holograms) {
			if ((scHolo.getASL1() == as || scHolo.getASL2() == as || scHolo.getASL3() == as)) {
				return scHolo;
			}
		}
		return null;
	}
	
	public SCHolo getHologram(ShulkerCrate sc) {
		for (SCHolo scHolo : holograms) {
			if (scHolo.getSC().getId() == sc.getId()) {
				return scHolo;
			}
		}
		return null;
	}
	
//	public SCHolo getHologram(World world, int x, int y, int z) {
//		for (SCHolo scHolo : holograms) {
//			if (scHolo.getWorld() == world && scHolo.getX() == x && scHolo.getY() == y && scHolo.getZ() == z) {
//				return scHolo;
//			}
//		}
//		return null;
//	}
	
	public void summonSCHolograms() {
		if (!core.getConfigs().getConfig().getBoolean("ShulkerCrates.Holograms.Enabled")) {
			return;
		}
		
		double height = core.getConfigs().getConfig().getDouble("ShulkerCrates.Holograms.Height");
		
		for (ShulkerCrate sc : core.getShulkerManager().getCrates().values()) {
			if (getHologram(sc) == null) {
				holograms.add(new SCHolo(core, sc.getWorld(), sc.getX() + 0.5D, sc.getY() + height + 0.15D, sc.getZ() + 0.5D, sc));
			}
		}
	}
	
	public void removeSCHolograms() {
		for (SCHolo scHolo : holograms) {
			scHolo.remove();
		}
		holograms.clear();
	}
	
	public List<SCHolo> getHolograms() {
		return holograms;
	}

	public void removeHologram(ShulkerCrate crate) {
		holograms.remove(getHologram(crate));
	}
	
}
