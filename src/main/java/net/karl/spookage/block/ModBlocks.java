package net.karl.spookage.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.karl.spookage.SpookageMod;
import net.karl.spookage.world.tree.SpookSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //New Blocks
    public static final Block SPOOK_BLOCK = registerBlock("spook_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).hardness(15)));
    public static final Block RAW_SPOOK_BLOCK = registerBlock("raw_spook_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).hardness(15)));
    public static final Block SPOOK_ORE = registerBlock("spook_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).hardness(8)));
    public static final Block SPOOK_STONE = registerBlock("spook_stone",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).hardness(5)));
    public static final Block SPOOK_COBBLESTONE = registerBlock("spook_cobblestone",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).hardness(5.5f)));
    public static final Block CHARRED_BUSH = registerBlock("charred_bush",
            new Block(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH)));
    public static final Block SPOOK_LOG = registerBlock("spook_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LOG)));
    public static final Block SPOOK_WOOD = registerBlock("spook_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_WOOD)));
    public static  final Block STRIPPED_SPOOK_LOG = registerBlock("stripped_spook_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_LOG)));
    public static  final Block STRIPPED_SPOOK_WOOD = registerBlock("stripped_spook_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_WOOD)));
    public static final Block SPOOK_PLANKS = registerBlock("spook_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));
    public static final Block SPOOK_LEAVES = registerBlock("spook_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES)));
    public static final Block SPOOK_SAPLING = registerBlock("spook_sapling",
            new SaplingBlock(new SpookSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
    public static final Block SPOOK_TRAPDOOR = registerBlock("spook_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_TRAPDOOR), new BlockSetType("spook")));
    public static final Block SPOOK_DOOR = registerBlock("spook_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_DOOR), new BlockSetType("spook")));





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
