package ml.bmlzootown;

import ml.bmlzootown.generator.FlatLandsGenerator;
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
