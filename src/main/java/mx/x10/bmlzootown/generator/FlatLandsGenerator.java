package mx.x10.bmlzootown.generator;

import mx.x10.bmlzootown.FlatLands;
import mx.x10.bmlzootown.populators.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Brandon on 3/4/2016.
 */
public class FlatLandsGenerator extends ChunkGenerator {

    @SuppressWarnings("unused")
    private FlatLands plugin;

    public FlatLandsGenerator(FlatLands instance) {
        this.plugin = instance;
    }

    public List<BlockPopulator> getDefaultPopulators(World world) {
        ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();
        populators.add(new FlatLandsTreePopulator());
        populators.add(new FlatLandsOrePopulator());
        populators.add(new FlatLandsChestPopulator());
        populators.add(new FlatLandsGrassPopulator());
        populators.add(new FlatLandsRiverPopulator());
        return populators;
    }

    public Location getFixedSpawnLocation(World world, Random random) {
        return new Location(world, 0, 5, 0);
    }

    private int coordsToInt(int x, int y, int z) {
        return (x * 16 + z) * 128 + y;
    }

    @SuppressWarnings("deprecated")
    public byte[] generate(World world, Random rand, int chunkX, int chunkZ) {
        byte[] blocks = new byte[32768];
        int x, y, z;

        for (x = 0; x < 16; ++x) {
            for (z = 0; z < 16; ++z) {
                blocks[this.coordsToInt(x,0,z)] = (byte) Material.BEDROCK.getId();

                for (y = 59; y < 64; ++y) {
                    blocks[this.coordsToInt(x,y,z)] = (byte) Material.DIRT.getId();
                }

                for (y = 1; y < 59; ++y) {
                    blocks[this.coordsToInt(x,y,z)] = (byte) Material.STONE.getId();
                }

                blocks[this.coordsToInt(x,64,z)] = (byte) Material.GRASS.getId();
            }
        }

        return blocks;
    }

}
