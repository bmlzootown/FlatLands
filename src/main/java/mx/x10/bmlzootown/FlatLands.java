package mx.x10.bmlzootown;

import mx.x10.bmlzootown.listeners.BlazePowderSmeltEvent;
import mx.x10.bmlzootown.listeners.BlazeRodCraftingEvent;
import mx.x10.bmlzootown.recipes.BlazePowderRecipe;
import mx.x10.bmlzootown.generator.FlatLandsGenerator;
import mx.x10.bmlzootown.recipes.BlazeRodRecipe;
import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Created by Brandon on 3/4/2016.
 */
public class FlatLands extends JavaPlugin {

    private Logger log = Logger.getLogger("minecraft");

    public void onEnable() {
        Bukkit.addRecipe(BlazePowderRecipe.blazePowderRecipe());
        Bukkit.addRecipe(BlazeRodRecipe.blazeRodRecipe());
        Bukkit.getPluginManager().registerEvents(new BlazePowderSmeltEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BlazeRodCraftingEvent(), this);
    }

    public void onDisable() {

    }

    public void logMessage(String msg) {
        PluginDescriptionFile pdFile = this.getDescription();
        this.log.info(pdFile.getName() + " " + pdFile.getVersion() + ": " + msg);
    }

    public ChunkGenerator getDefaultWorldGenerator(String worldName, String uid) {
        return new FlatLandsGenerator(this);
    }

}
