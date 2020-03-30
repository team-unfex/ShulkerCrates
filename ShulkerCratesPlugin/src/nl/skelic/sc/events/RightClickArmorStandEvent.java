package nl.skelic.sc.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

import nl.skelic.sc.Core;

public class RightClickArmorStandEvent implements Listener {
	
	private Core core;
	
	public RightClickArmorStandEvent(Core core) {
		this.core = core;
	}
	
	@EventHandler
	public void manipulate(PlayerArmorStandManipulateEvent e){
		if(!e.getRightClicked().isVisible()) {
	    	e.setCancelled(true);
	    }
	}
}
