package net.karl.spookage.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.karl.spookage.SpookageMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //New Blocks
    public static final Block SPOOK_BLOCK = registerBlock("spook_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RAW_SPOOK_BLOCK = registerBlock("raw_spook_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block SPOOK_ORE = registerBlock("spook_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block SPOOK_STONE = registerBlock("spook_stone",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block SPOOK_COBBLESTONE = registerBlock("spook_cobblestone",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block CHARRED_BUSH = registerBlock("charred_bush",
            new Block(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH)));









    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SpookageMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(SpookageMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        SpookageMod.LOGGER.info("Registering ModBlocks for " + SpookageMod.MOD_ID);
    }
}
