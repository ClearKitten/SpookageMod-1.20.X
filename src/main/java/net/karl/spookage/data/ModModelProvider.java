package net.karl.spookage.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.karl.spookage.block.ModBlocks;
import net.karl.spookage.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureMap;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RAW_SPOOK_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SPOOK_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SPOOK_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SPOOK_COBBLESTONE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SPOOK_STONE);

        blockStateModelGenerator.registerLog(ModBlocks.SPOOK_LOG).log(ModBlocks.SPOOK_LOG).wood(ModBlocks.SPOOK_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_SPOOK_LOG).log(ModBlocks.STRIPPED_SPOOK_LOG).wood(ModBlocks.STRIPPED_SPOOK_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SPOOK_PLANKS);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SPOOK_TRAPDOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.SPOOK_DOOR);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SPOOK_LEAVES);


        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.SPOOK_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED,
                TextureMap.cross(ModBlocks.SPOOK_SAPLING));

        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.CHARRED_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED,
                TextureMap.cross(ModBlocks.CHARRED_BUSH));



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
       generateItems(itemModelGenerator);
       generateToolItems(itemModelGenerator);
       generateArmorItems(itemModelGenerator);


    }
    private void generateArmorItems(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.register(ModItems.SPOOK_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPOOK_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPOOK_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPOOK_BOOTS, Models.GENERATED);
    }
    private void generateToolItems(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.register(ModItems.SPOOK_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPOOK_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPOOK_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPOOK_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPOOK_SHOVEL, Models.GENERATED);
    }
    private void generateItems(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.register(ModItems.SPOOK_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SPOOK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHARRED_STICK, Models.GENERATED);
    }
}
