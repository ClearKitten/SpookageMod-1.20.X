package net.karl.spookage.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.karl.spookage.block.ModBlocks;
import net.karl.spookage.item.ModItems;
import net.minecraft.client.gl.Uniform;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
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
        addDrop(ModBlocks.SPOOK_COBBLESTONE);
        addDrop(ModBlocks.SPOOK_LOG);
        addDrop(ModBlocks.SPOOK_WOOD);
        addDrop(ModBlocks.STRIPPED_SPOOK_LOG);
        addDrop(ModBlocks.STRIPPED_SPOOK_WOOD);
        addDrop(ModBlocks.SPOOK_PLANKS);
        addDrop(ModBlocks.SPOOK_TRAPDOOR);
        addDrop(ModBlocks.SPOOK_DOOR, doorDrops(ModBlocks.SPOOK_DOOR));
        addDrop(ModBlocks.SPOOK_SAPLING);

        addDrop(ModBlocks.SPOOK_LEAVES, BlockLootTableGenerator.dropsWithSilkTouchOrShears(ModBlocks.SPOOK_LEAVES,
                ((LeafEntry.Builder<?>)this.addSurvivesExplosionCondition(ModBlocks.SPOOK_LEAVES, ItemEntry.builder(ModItems.CHARRED_STICK)))
                        .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.06f))).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                .conditionally(WITHOUT_SILK_TOUCH.and(WITH_SHEARS.invert())).with((LootPoolEntry.Builder<?>)
                        ((LeafEntry.Builder<?>)this.applyExplosionDecay(ModBlocks.SPOOK_LEAVES, ItemEntry.builder(ModItems.CHARRED_STICK)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))))
                                .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.02f, 0.022222223f, 0.025f, 0.033333335f, 0.1f)))));




        addDrop(ModBlocks.SPOOK_STONE, LootTable.builder().pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1f))
                .with(ItemEntry.builder(ModBlocks.SPOOK_STONE)
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)))
                        .conditionally(WITH_SILK_TOUCH))
                .with(ItemEntry.builder(ModBlocks.SPOOK_COBBLESTONE)
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)))
                        .conditionally(WITHOUT_SILK_TOUCH))));


        addDrop(ModBlocks.SPOOK_ORE, oreDrops(ModBlocks.SPOOK_ORE, ModItems.RAW_SPOOK));

        addDrop(ModBlocks.CHARRED_BUSH, LootTable.builder().pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1f))
                .with(ItemEntry.builder(ModBlocks.CHARRED_BUSH)
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)))
                        .conditionally(WITH_SHEARS))
                .with(ItemEntry.builder(ModItems.CHARRED_STICK)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0f, 2f)))
                        .conditionally(WITH_SHEARS.invert()))));





    }
}
