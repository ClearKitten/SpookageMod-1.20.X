package net.karl.spookage.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.karl.spookage.block.ModBlocks;
import net.karl.spookage.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
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
        offerSmelting(exporter, List.of(ModItems.RAW_SPOOK), RecipeCategory.MISC, ModItems.SPOOK_INGOT,
                0.7f, 200, "spook");
        offerBlasting(exporter, List.of(ModItems.RAW_SPOOK), RecipeCategory.MISC, ModItems.SPOOK_INGOT,
                0.7f, 100, "spook");
        offerSmelting(exporter, List.of(ModBlocks.SPOOK_COBBLESTONE), RecipeCategory.MISC, ModBlocks.SPOOK_STONE,
                0.7f, 200, "spook");




        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SPOOK_INGOT, RecipeCategory.DECORATIONS,
                ModBlocks.SPOOK_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SPOOK, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_SPOOK_BLOCK);




        //Good Example
        /*ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_SPOOK)
                .pattern("SSS")
                .pattern("S#S")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('#', ModItems.SPOOK_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.STONE),
                        FabricRecipeProvider.conditionsFromItem(Items.STONE))
                .criterion(FabricRecipeProvider.hasItem(ModItems.SPOOK_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SPOOK_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.RAW_SPOOK)));*/
    }
}
