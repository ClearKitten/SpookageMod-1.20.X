package net.karl.spookage.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlockRegistry {
    public static  void registerFlammableBlocks(){
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.SPOOK_LEAVES, 30, 60);
        registry.add(ModBlocks.SPOOK_PLANKS, 5, 20);
        registry.add(ModBlocks.STRIPPED_SPOOK_LOG, 5, 5);
        registry.add(ModBlocks.SPOOK_LOG, 5, 5);
    }
}
