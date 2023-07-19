package net.karl.spookage.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.karl.spookage.SpookageMod;
import net.karl.spookage.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup SPOOKAGE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(SpookageMod.MOD_ID, "spook"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.spookage"))
                    .icon(() -> new ItemStack(ModItems.SPOOK_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.SPOOK_INGOT);
                        entries.add(ModItems.RAW_SPOOK);

                        entries.add(ModItems.SPOOK_PICKAXE);
                        entries.add(ModItems.SPOOK_AXE);
                        entries.add(ModItems.SPOOK_HOE);
                        entries.add(ModItems.SPOOK_SWORD);
                        entries.add(ModItems.SPOOK_SHOVEL);

                        entries.add(ModItems.SPOOK_HELMET);
                        entries.add(ModItems.SPOOK_CHESTPLATE);
                        entries.add(ModItems.SPOOK_LEGGINGS);
                        entries.add(ModItems.SPOOK_BOOTS);

                        entries.add(ModBlocks.SPOOK_BLOCK);
                        entries.add(ModBlocks.RAW_SPOOK_BLOCK);
                        entries.add(ModBlocks.CHARRED_BUSH);
                        entries.add(ModBlocks.SPOOK_ORE);
                        entries.add(ModBlocks.SPOOK_COBBLESTONE);
                        entries.add(ModBlocks.SPOOK_STONE);

                        entries.add(ModBlocks.SPOOK_LOG);
                        entries.add(ModBlocks.SPOOK_WOOD);
                        entries.add(ModBlocks.STRIPPED_SPOOK_LOG);
                        entries.add(ModBlocks.STRIPPED_SPOOK_WOOD);
                        entries.add(ModBlocks.SPOOK_PLANKS);
                        entries.add(ModBlocks.SPOOK_SAPLING);
                        entries.add(ModBlocks.SPOOK_DOOR);
                        entries.add(ModBlocks.SPOOK_TRAPDOOR);
                        entries.add(ModBlocks.SPOOK_LEAVES);

                    }).build());


    public static void registerItemGroups(){
        SpookageMod.LOGGER.info("Registering Item Groups fir " + SpookageMod.MOD_ID);
    }
}
