package net.karl.spookage;

import net.fabricmc.api.ModInitializer;

import net.karl.spookage.block.ModBlocks;
import net.karl.spookage.item.ModItemGroups;
import net.karl.spookage.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpookageMod implements ModInitializer {
	public static final String MOD_ID = "spookage";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}