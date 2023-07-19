package net.karl.spookage.world;

import net.karl.spookage.SpookageMod;
import net.karl.spookage.block.ModBlockTags;
import net.karl.spookage.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.Registerable;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPOOK_KEY = registerKey("spook");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPOOK_ORE_KEY = registerKey("spook_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPOOK_STONE_KEY = registerKey("spook_stone");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest spookStoneReplaceables = new TagMatchRuleTest(ModBlockTags.SPOOK_STONE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldSpookStone =
                List.of(OreFeatureConfig.createTarget(spookStoneReplaceables, ModBlocks.SPOOK_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldSpookOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.SPOOK_STONE.getDefaultState()));



        register(context, SPOOK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.SPOOK_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.of(ModBlocks.SPOOK_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, SPOOK_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSpookStone, 8));
        register(context, SPOOK_STONE_KEY, Feature.ORE, new OreFeatureConfig(overworldSpookOres, 50));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(SpookageMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
