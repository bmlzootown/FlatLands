package mx.x10.bmlzootown.populators;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

/**
 * Created by Brandon on 3/5/2016.
 */
public class FlatLandsChestPopulator extends BlockPopulator {

    private static final BlockFace[] faces = {BlockFace.DOWN, BlockFace.EAST,
            BlockFace.NORTH, BlockFace.SOUTH, BlockFace.UP, BlockFace.WEST};

    public void populate(World world, Random random, Chunk chunk) {
        if (random.nextInt(100) < 10) {
            for (int i = 0; i < 1; i++) {
                int x = random.nextInt(16);
                int y = 65;
                int z = random.nextInt(16);
                Block b = chunk.getBlock(x, y, z);
                if (b.getType().equals(Material.LOG) || b.getType().equals(Material.LOG_2)) {
                    return;
                }
                for (BlockFace face : faces) {
                    if (b.getRelative(face).getType() == Material.CHEST) {
                        return;
                    }
                }
                Block c = chunk.getBlock(x,y - 1,z);
                c.setType(Material.DIRT);
                c.setData((byte)1);
                Block d = chunk.getBlock(x,y - 2,z);
                d.setType(Material.CHEST);
                Chest chest = (Chest) d.getState();
                Inventory inv = chest.getBlockInventory();
                inv.setItem(0, new ItemStack(Material.GOLDEN_APPLE, 1));
                inv.setItem(1, new ItemStack(Material.DIAMOND, 1));
                inv.setItem(2, new ItemStack(Material.IRON_INGOT, 3));
                chest.getInventory().setContents(inv.getContents());
            }
        }
    }

}
