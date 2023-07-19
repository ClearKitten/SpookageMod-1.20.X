package net.karl.spookage.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.karl.spookage.block.ModBlocks;
import net.karl.spookage.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        blockCrafting(exporter);
        smeltingCrafting(exporter);
        toolCrafting(exporter);
        armorCrafting(exporter);
    }
    private void blockCrafting(Consumer<RecipeJsonProvider> exporter){
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SPOOK_INGOT, RecipeCategory.DECORATIONS,
                ModBlocks.SPOOK_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SPOOK, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_SPOOK_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPOOK_PLANKS, 4)
                        .input(ModBlocks.SPOOK_LOG)
                                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SPOOK_PLANKS),
                                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SPOOK_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.SPOOK_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SPOOK_LOG)).offerTo(exporter, "spook_planks_from_spook_log");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPOOK_PLANKS, 4)
                .input(ModBlocks.STRIPPED_SPOOK_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SPOOK_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SPOOK_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_SPOOK_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_SPOOK_LOG)).offerTo(exporter, "spook_planks_from_stripped_spook_log");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPOOK_PLANKS, 4)
                .input(ModBlocks.SPOOK_WOOD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SPOOK_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SPOOK_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.SPOOK_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SPOOK_WOOD)).offerTo(exporter, "spook_planks_from_spook_wood");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPOOK_PLANKS, 4)
                .input(ModBlocks.STRIPPED_SPOOK_WOOD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SPOOK_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SPOOK_PLANKS)).criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_SPOOK_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_SPOOK_WOOD)).offerTo(exporter, "spook_planks_from_stripped_spook_wood");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPOOK_WOOD, 3)
                .pattern("SS")
                .pattern("SS")
                .input('S', ModBlocks.SPOOK_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SPOOK_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SPOOK_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.SPOOK_WOOD)));

        //Spook Trapdoor
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPOOK_TRAPDOOR, 2)
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModBlocks.SPOOK_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SPOOK_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SPOOK_PLANKS))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.SPOOK_TRAPDOOR)));

        //Spook Door
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPOOK_DOOR, 3)
                .pattern("SS")
                .pattern("SS")
                .pattern("SS")
                .input('S', ModBlocks.SPOOK_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SPOOK_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.SPOOK_PLANKS))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.SPOOK_DOOR)));




    }



    private void smeltingCrafting(Consumer<RecipeJsonProvider> exporter){
        offerSmelting(exporter, List.of(ModItems.RAW_SPOOK), RecipeCategory.MISC, ModItems.SPOOK_INGOT,
                0.7f, 200, "spook");
        offerBlasting(exporter, List.of(ModItems.RAW_SPOOK), RecipeCategory.MISC, ModItems.SPOOK_INGOT,
                0.7f, 100, "spook");
        offerSmelting(exporter, List.of(ModBlocks.SPOOK_COBBLESTONE), RecipeCategory.MISC, ModBlocks.SPOOK_STONE,
                0.7f, 200, "spook");
    }
    private void armorCrafting(Consumer<RecipeJsonProvider> exporter){
        //Spook Helmet
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SPOOK_HELMET)
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .input('S', ModItems.SPOOK_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SPOOK_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SPOOK_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.SPOOK_HELMET)));

        //Spook Chestplate
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SPOOK_CHESTPLATE)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.SPOOK_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SPOOK_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SPOOK_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.SPOOK_CHESTPLATE)));

        //Spook Leggings
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SPOOK_LEGGINGS)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.SPOOK_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SPOOK_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SPOOK_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.SPOOK_LEGGINGS)));

        //Spook Boots
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SPOOK_BOOTS)
                .pattern("S S")
                .pattern("S S")
                .pattern("   ")
                .input('S', ModItems.SPOOK_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SPOOK_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SPOOK_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.SPOOK_BOOTS)));
    }
    private void toolCrafting(Consumer<RecipeJsonProvider> exporter){
        //Spook Pickaxe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SPOOK_PICKAXE)
                .pattern("SSS")
                .pattern(" C ")
                .pattern(" C ")
                .input('S', ModItems.SPOOK_INGOT)
                .input('C', ModItems.CHARRED_STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SPOOK_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SPOOK_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModItems.CHARRED_STICK),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CHARRED_STICK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.SPOOK_PICKAXE)));

        //Spook Axe
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SPOOK_AXE)
                .pattern("SS ")
                .pattern("SC ")
                .pattern(" C ")
                .input('S', ModItems.SPOOK_INGOT)
                .input('C', ModItems.CHARRED_STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SPOOK_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SPOOK_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModItems.CHARRED_STICK),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CHARRED_STICK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.SPOOK_AXE)));

        //Spook Hoe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SPOOK_HOE)
                .pattern("SS ")
                .pattern(" C ")
                .pattern(" C ")
                .input('S', ModItems.SPOOK_INGOT)
                .input('C', ModItems.CHARRED_STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SPOOK_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SPOOK_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModItems.CHARRED_STICK),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CHARRED_STICK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.SPOOK_HOE)));

        //Spook Shovel
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SPOOK_SHOVEL)
                .pattern(" S ")
                .pattern(" C ")
                .pattern(" C ")
                .input('S', ModItems.SPOOK_INGOT)
                .input('C', ModItems.CHARRED_STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SPOOK_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SPOOK_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModItems.CHARRED_STICK),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CHARRED_STICK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.SPOOK_SHOVEL)));

        //Spook Sword
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SPOOK_SWORD)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" C ")
                .input('S', ModItems.SPOOK_INGOT)
                .input('C', ModItems.CHARRED_STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SPOOK_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SPOOK_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModItems.CHARRED_STICK),
                        FabricRecipeProvider.conditionsFromItem(ModItems.CHARRED_STICK))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.SPOOK_SWORD)));
    }
}
