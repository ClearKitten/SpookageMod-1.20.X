package net.karl.spookage.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.karl.spookage.block.ModBlocks;
import net.karl.spookage.item.ModItems;
import net.minecraft.client.gl.Uniform;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProviderType;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import java.util.Random;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SPOOK_BLOCK);
        addDrop(ModBlocks.RAW_SPOOK_BLOCK);
        addDrop(ModBlocks.SPOOK_STONE);
        addDrop(ModBlocks.SPOOK_COBBLESTONE);
        addDrop(ModBlocks.SPOOK_ORE, oreDrops(ModBlocks.SPOOK_ORE, ModItems.RAW_SPOOK));
        //addDrop(ModBlocks.CHARRED_BUSH, dropsWithShears(ModBlocks.CHARRED_BUSH), drops(ModItems.CHARRED_STICK, UniformLootNumberProvider.create(0f, 2f))));
        //addDrop(ModBlocks.CHARRED_BUSH, dropsWithShears(ModBlocks.CHARRED_BUSH));
        //addDrop(ModBlocks.CHARRED_BUSH, LootTable.builder().pool(LootPool.builder().rolls(UniformLootNumberProvider.create(0f, 2f)).with(ItemEntry.builder(ModItems.CHARRED_STICK))));


    }
}
