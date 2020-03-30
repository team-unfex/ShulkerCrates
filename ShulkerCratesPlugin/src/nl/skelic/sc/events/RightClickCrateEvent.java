package nl.skelic.sc.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.ShulkerBox;
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import net.minecraft.server.v1_13_R2.BlockPosition;
import net.minecraft.server.v1_13_R2.World;
import nl.skelic.sc.Core;
import nl.skelic.sc.menus.CratesMenu;

public class RightClickCrateEvent implements Listener {
	
	private Core core;
	
	public RightClickCrateEvent(Core core) {
		this.core = core;
	}
	
	@EventHandler
	public void rightClickCrateEvent(PlayerInteractEvent event) {
		CratesMenu crateMenu = new CratesMenu(event.getPlayer(), core);
		Player p = event.getPlayer();
		if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		
		if(!event.getClickedBlock().getType().name().endsWith("SHULKER_BOX")) return;
		
		if(!core.getShulkerManager().exists(event.getClickedBlock().getLocation())) return;
		
		ShulkerBox sb = (ShulkerBox) event.getClickedBlock().getState();
		
		// TODO: Open GUI.
		event.setCancelled(true);
		crateMenu.openMenu(p);
		playShulkerAction(sb, true);
		// TODO: Check if player has key.
		
	}
	
	@EventHandler
    public void onInvClose(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        org.bukkit.block.Block tblock = player.getTargetBlockExact(5);
        Inventory inv = e.getInventory();
       
        if (inv.getTitle().equals("Crates") && tblock.getType().name().endsWith("SHULKER_BOX")) {
        	ShulkerBox sb = (ShulkerBox) tblock.getState();
        	playShulkerAction(sb, false);
        }
    }
	
//	@SuppressWarnings("deprecation")
//	public static void changeChestState(Location loc, boolean open) {
//	    byte dataByte = (open) ? (byte) 1 : 0; // The byte of data used for the note and animation packet (1 if true, 0 if false)
//	    for (Player player : Bukkit.getOnlinePlayers()) {
//	        player.playNote(loc, (byte) 1, dataByte); // Play the sound
//	        World world = ((CraftWorld) loc.getWorld()).getHandle();
//	        BlockPosition position = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()); // Create the block position using loc
//	        // Instantiate animation packet, get NMS Block using getById() and loc.getBlock() (deprecated), the server version may vary
//	        PacketPlayOutBlockAction blockActionPacket = new PacketPlayOutBlockAction(position, world.getType(position).getBlock(), (byte) 1, dataByte);
//	        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(blockActionPacket); // Send animation packet to CraftPlayer
//	    }
//	}
	
	public static void playShulkerAction(ShulkerBox sb, boolean open) {
		Location loc = sb.getLocation();
		World world = ((CraftWorld) loc.getWorld()).getHandle();
		BlockPosition pos = new BlockPosition(loc.getX(), loc.getY(), loc.getZ()); 
		world.playBlockAction(pos, world.getType(pos).getBlock(), 1, open ? 1 : 0);
	}

}
