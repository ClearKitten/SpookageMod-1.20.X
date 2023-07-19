package net.karl.spookage.block;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModStrippableBlockRegistry {
    public static void registerStrippableBlocks(){
        StrippableBlockRegistry.register(ModBlocks.SPOOK_LOG, ModBlocks.STRIPPED_SPOOK_LOG);
        StrippableBlockRegistry.register(ModBlocks.SPOOK_WOOD, ModBlocks.STRIPPED_SPOOK_WOOD);
    }
}
