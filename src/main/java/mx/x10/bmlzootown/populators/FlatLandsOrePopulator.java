package mx.x10.bmlzootown.populators;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class FlatLandsOrePopulator extends BlockPopulator {
    int[][] values = {
            { 0, 0, 1 },
            { 1, 0, 1 },
            { 1, 0, 0 },
            { 0, 1, 0 },
            { 0, 1, 1 },
            { 1, 1, 1 },
            { 1, 1, 0 } };

    public void populate(World world, Random rand, Chunk chunk) {
        for (int i = 0; i < 25; i++) {
            generateRandomOreChunks(chunk, rand, 59, Material.COAL_ORE, 1200);
        }
        for (int i = 0; i < 20; i++) {
            generateRandomOreChunks(chunk, rand, 46, Material.IRON_ORE, 1000);
        }
        for (int i = 0; i < 15; i++) {
            generateRandomOreChunks(chunk, rand, 23, Material.LAPIS_ORE, 300);
        }
        for (int i = 0; i < 25; i++) {
            generateRandomOreChunks(chunk, rand, 3, Material.STATIONARY_LAVA, 5000);
        }
        for (int i = 0; i < 10; i++) {
            generateRandomOreChunks(chunk, rand, 35, Material.GOLD_ORE, 400);
        }
        for (int i = 0; i < 6; i++) {
            generateRandomOreChunks(chunk, rand, 12, Material.REDSTONE_ORE, 1000);
        }
        for (int i = 0; i < 1; i++) {
            generateRandomOreChunks(chunk, rand, 12, Material.DIAMOND_ORE, 500);
        }
        for (int i = 0; i < 1; i++) {
            generateRandomOreChunks(chunk, rand, 32, Material.EMERALD_ORE, 0);
        }
    }

    public void generateRandomOreChunks(Chunk chunk, Random rand, int maxHeight, Material material, int firstChance) {
        int x = rand.nextInt(14) + 1;
        int y = rand.nextInt(maxHeight - 2) + 1;
        int z = rand.nextInt(14) + 1;
        if (chunk.getBlock(x, y, z).getType() == Material.STONE) {
            chunk.getBlock(x, y, z).setType(material);
        }
        int randVal = rand.nextInt(5000);
        int chance = 2;
        setStoneToOre(material, chunk, x, y, z);
        for (int i = 0; i < 7; i++) {
            if (randVal < firstChance / chance) {
                setStoneToOre(material, chunk, x + this.values[i][0], y + this.values[i][1], z + this.values[i][2]);
                chance *= 2;
            }
        }
    }

    public void setStoneToOre(Material material, Chunk chunk, int x, int y, int z) {
        Block block = chunk.getBlock(x, y - 1, z);
        if ((block.getType() == Material.STONE) || (block.getType() == Material.SANDSTONE) || (block.getType() == Material.ICE) || (block.getType() == Material.HARD_CLAY)) {
            block.setType(material);
        }
    }
}
