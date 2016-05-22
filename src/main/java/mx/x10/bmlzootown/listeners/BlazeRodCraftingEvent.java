package mx.x10.bmlzootown.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

/**
 * Created by Brandon on 5/21/2016.
 */
public class BlazeRodCraftingEvent implements Listener {
    public static ShapelessRecipe blazeRod;

    @EventHandler (priority = EventPriority.HIGHEST)
    public static void onCraft(PrepareItemCraftEvent event) {
        Recipe crafting = event.getRecipe();

        ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
        blazeRod = new ShapelessRecipe(blaze);

        blazeRod.addIngredient(8, Material.BLAZE_POWDER);
        blazeRod.addIngredient(1, Material.BONE);

        if (crafting.equals(blazeRod)) {
            if (event.getView().getPlayer().getWorld().getName() != "Flatlands") {
                event.getInventory().setResult(null);
            }
        }
    }

}
