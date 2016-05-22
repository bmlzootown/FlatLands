package mx.x10.bmlzootown.populators;

import org.bukkit.Chunk;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class FlatLandsTreePopulator extends BlockPopulator {
    public void populate(World world, Random rand, Chunk chunk) {
        int cX = chunk.getX() * 16;
        int cZ = chunk.getZ() * 16;
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                    int y = 64;
                    Block block = chunk.getBlock(x, y, z);

                    Biome currBiome = block.getBiome();
                    boolean doGen = true;

                    TreeType treeOne = TreeType.TREE;
                    TreeType treeTwo = TreeType.BIG_TREE;
                    if (block.getType() != Material.SAND) {
                        if (block.getType() == Material.SNOW_BLOCK) {
                            treeOne = TreeType.REDWOOD;
                            treeTwo = TreeType.REDWOOD;
                        } else if ((currBiome == Biome.MUSHROOM_ISLAND) || (currBiome == Biome.MUSHROOM_ISLAND_SHORE)) {
                            treeOne = TreeType.BROWN_MUSHROOM;
                            treeTwo = TreeType.RED_MUSHROOM;
                        } else if ((currBiome == Biome.JUNGLE) || (currBiome == Biome.JUNGLE_EDGE) || (currBiome == Biome.MUTATED_JUNGLE_EDGE) || (currBiome == Biome.JUNGLE_HILLS) || (currBiome == Biome.MUTATED_JUNGLE)) {
                            treeOne = TreeType.JUNGLE;
                            treeTwo = TreeType.JUNGLE_BUSH;
                        } else if ((currBiome == Biome.ICE_FLATS) || (currBiome == Biome.COLD_BEACH) || (currBiome == Biome.TAIGA_COLD) || (currBiome == Biome.TAIGA_COLD_HILLS) || (currBiome == Biome.MUTATED_TAIGA_COLD)) {
                            treeOne = TreeType.REDWOOD;
                            treeTwo = TreeType.REDWOOD;
                        } else if ((currBiome == Biome.REDWOOD_TAIGA) || (currBiome == Biome.MUTATED_TAIGA) || (currBiome == Biome.MUTATED_REDWOOD_TAIGA) || (currBiome == Biome.MUTATED_REDWOOD_TAIGA_HILLS)) {
                            treeOne = TreeType.MEGA_REDWOOD;
                            treeTwo = TreeType.REDWOOD;
                        } else if ((currBiome == Biome.ROOFED_FOREST) || (currBiome == Biome.MUTATED_ROOFED_FOREST)) {
                            treeOne = TreeType.DARK_OAK;
                            treeTwo = TreeType.DARK_OAK;
                        } else if ((currBiome == Biome.BIRCH_FOREST) || (currBiome == Biome.BIRCH_FOREST_HILLS) || (currBiome == Biome.MUTATED_BIRCH_FOREST) || (currBiome == Biome.MUTATED_BIRCH_FOREST_HILLS)) {
                            treeOne = TreeType.BIRCH;
                            treeTwo = TreeType.TALL_BIRCH;
                        } else if ((currBiome == Biome.FOREST) || (currBiome == Biome.FOREST_HILLS) || (currBiome == Biome.MUTATED_FOREST)) {
                            treeOne = TreeType.BIRCH;
                            treeTwo = TreeType.TREE;
                        } else if ((currBiome == Biome.SWAMPLAND) || (currBiome == Biome.MUTATED_SWAMPLAND)) {
                            treeOne = TreeType.SWAMP;
                            treeTwo = TreeType.SWAMP;
                        } else if ((currBiome == Biome.SAVANNA) || (currBiome == Biome.SAVANNA_ROCK) || (currBiome == Biome.MUTATED_SAVANNA) || (currBiome == Biome.MUTATED_SAVANNA_ROCK)) {
                            treeOne = TreeType.ACACIA;
                            treeTwo = TreeType.ACACIA;
                        } else if ((currBiome == Biome.RIVER) || (currBiome == Biome.FROZEN_RIVER)) {
                            doGen = false;
                        }
                        if ((block.getType() != Material.AIR) && (chunk.getBlock(x, y + 1, z).getType() == Material.AIR)) {
                            if (doGen) {
                                int randVal = rand.nextInt(100);
                                if (randVal < 1) {
                                    world.generateTree(new Location(world, x + cX, y + 1, z + cZ), rand.nextInt(100) < 70 ? treeOne : treeTwo);
                                }
                            }
                        }
                    }

            }
        }
    }
}
