/**
 * 
 */
package myz.Listeners;

import java.lang.reflect.Field;

import myz.MyZ;
import myz.Utilities.Utilities;
import net.minecraft.server.v1_6_R3.Connection;
import net.minecraft.server.v1_6_R3.EntityPlayer;
import net.minecraft.server.v1_6_R3.Packet205ClientCommand;

import org.bukkit.craftbukkit.v1_6_R3.entity.CraftPlayer;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Does not include player-kill-player events.
 * 
 * @author Jordan
 */
public class PlayerDeath implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	private void onDeath(PlayerDeathEvent e) {
		if (!MyZ.instance.getWorlds().contains(e.getEntity().getWorld().getName())) { return; }
		// Get rid of our horse.
		for (Horse horse : e.getEntity().getWorld().getEntitiesByClass(Horse.class))
			if (horse.getOwner() != null && horse.getOwner().getName() != null
					&& horse.getOwner().getName().equals(e.getEntity().getName())) {
				horse.setOwner(null);
				horse.setTamed(false);
				horse.setDomestication(0);
			}

		// Become a zombie and teleport back to spawn to be kicked.
		Utilities.spawnPlayerZombie(e.getEntity(), null);

		revive(e.getEntity());
		MyZ.instance.putPlayerAtSpawn(e.getEntity(), true);

		e.setDroppedExp(0);
		e.getDrops().clear();
	}

	/**
	 * Bypass the respawn screen and come back to life immediately.
	 * 
	 * @param p
	 *            The player to respawn immediately.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void revive(Player p) {
		if (!p.isDead())
			return;
		try {
			Class packet = Packet205ClientCommand.class;
			Object name = packet.getConstructor(new Class[0]).newInstance(new Object[0]);
			Field a = packet.getDeclaredField("a");
			a.setAccessible(true);
			a.set(name, 1);
			Object nmsPlayer = CraftPlayer.class.getMethod("getHandle", new Class[0]).invoke(p, new Object[0]);
			Field con = EntityPlayer.class.getDeclaredField("playerConnection");
			con.setAccessible(true);
			Object handle = con.get(nmsPlayer);
			packet.getDeclaredMethod("handle", Connection.class).invoke(name, handle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
