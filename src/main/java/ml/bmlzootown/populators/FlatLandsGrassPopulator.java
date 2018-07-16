package ml.bmlzootown.populators;

import org.bukkit.Chunk;
import org.bukkit.GrassSpecies;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.material.LongGrass;

import java.util.Random;

/**
 * Created by Brandon on 3/5/2016.
 */
public class FlatLandsGrassPopulator extends BlockPopulator {

    public void populate(World world, Random random, Chunk chunk) {
        int x,y = 65,z;

        for (x = 0; x < 16; ++x) {
            for (z = 0; z < 16; ++z) {
                if (random.nextInt(100) < 10) {
                    Block b = chunk.getBlock(x,y,z);
                    if (b.getType().equals(Material.AIR)) {
                        if (!b.getBiome().equals(Biome.RIVER)) {
                            b.setType(Material.LONG_GRASS);
                            b.setData((byte) 1);
                        }
                    }
                }
                if (random.nextInt(200) < 1) {
                    Block b = chunk.getBlock(x,y,z);
                    if (b.getType().equals(Material.AIR)) {
                        if (!b.getBiome().equals(Biome.RIVER)) {
                            b.setType(Material.DOUBLE_PLANT);
                            b.setData((byte) 2);
                            Block c = chunk.getBlock(x, y + 1, z);
                            c.setType(Material.DOUBLE_PLANT);
                            c.setData((byte) 8);
                        }
                    }
                }
                if (random.nextInt(500) < 1) {
                    Block b = chunk.getBlock(x,y,z);
                    if (b.getType().equals(Material.AIR)) {
                        if (!b.getBiome().equals(Biome.RIVER)) {
                            b.setType(Material.RED_ROSE);
                            b.setData((byte) random.nextInt(8));
                        }
                    }
                }
                if (random.nextInt(500) < 1) {
                    Block b = chunk.getBlock(x,y,z);
                    if (b.getType().equals(Material.AIR)) {
                        if (!b.getBiome().equals(Biome.RIVER)) {
                            b.setType(Material.YELLOW_FLOWER);
                        }
                    }
                }
                if (random.nextInt(500) < 1) {
                    Block b = chunk.getBlock(x,y,z);
                    if (b.getType().equals(Material.AIR)) {
                        if (!b.getBiome().equals(Biome.RIVER)) {
                            b.setType(Material.DOUBLE_PLANT);
                            b.setData((byte) random.nextInt(5));
                            Block c = chunk.getBlock(x, y + 1, z);
                            c.setType(Material.DOUBLE_PLANT);
                            c.setData((byte) 8);
                        }
                    }
                }
            }
        }
    }
}
