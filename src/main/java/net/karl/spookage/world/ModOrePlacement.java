package net.karl.spookage.world;

import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModOrePlacement {
    public static List<PlacementModifier> modifiers(PlacementModifier countModifer, PlacementModifier heightModifier){
        return List.of(countModifer, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier){
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    public static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier){
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
