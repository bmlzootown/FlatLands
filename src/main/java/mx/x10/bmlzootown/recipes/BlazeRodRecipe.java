package mx.x10.bmlzootown.recipes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Created by Brandon on 5/21/2016.
 */
public class BlazeRodRecipe {

    public static ShapedRecipe blazeRodRecipe() {
        ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
        ShapedRecipe blazeRod = new ShapedRecipe(blaze);
        blazeRod.shape("***","*!*","***");
        blazeRod.setIngredient('*', Material.BLAZE_POWDER);
        blazeRod.setIngredient('!', Material.BONE);

        return blazeRod;
    }

}
