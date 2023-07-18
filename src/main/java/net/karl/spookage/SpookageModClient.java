package net.karl.spookage;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.karl.spookage.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class SpookageModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHARRED_BUSH);
    }
}
