package net.karl.spookage.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SpookToolMaterial implements ToolMaterial {
    public static final SpookToolMaterial INSTANCE = new SpookToolMaterial();
    @Override
    public int getDurability() {
        return 2642;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 12;
    }

    @Override
    public float getAttackDamage() {
        return 6f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.SPOOK_INGOT);
    }

}
