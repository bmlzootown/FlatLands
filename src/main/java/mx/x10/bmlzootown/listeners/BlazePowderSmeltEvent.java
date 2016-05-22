package mx.x10.bmlzootown.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Brandon on 5/21/2016.
 */
public class BlazePowderSmeltEvent implements Listener {

    @EventHandler
    public static void onSmeltEvent(FurnaceSmeltEvent event) {
        if (event.getSource() == new ItemStack(Material.SULPHUR)) {
            if (event.getBlock().getWorld().getName() != "Flatlands") {
                Bukkit.broadcastMessage("herpes");
                event.setCancelled(true);
            }
        }
    }

}
