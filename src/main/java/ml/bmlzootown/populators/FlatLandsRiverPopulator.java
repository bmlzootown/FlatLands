package ml.bmlzootown.populators;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

/**
 * Created by Brandon on 3/5/2016.
 */
public class FlatLandsRiverPopulator extends BlockPopulator {

    public void populate(World world, Random random, Chunk chunk) {

        int x,y = 64,z;

        Block b;
        for (x = 0; x < 16; ++x) {
            for (z = 0; z < 16; ++z) {
                b = chunk.getBlock(x,y,z);
                if (b.getType().equals(Material.GRASS)) {
                    if (b.getBiome().equals(Biome.RIVER) || b.getBiome().equals(Biome.FROZEN_RIVER)) {
                        b.setType(Material.STATIONARY_WATER);
                        Block c = chunk.getBlock(x, y - 1, z);
                        c.setType(Material.STATIONARY_WATER);
                    }
                }
            }
        }

    }
}
