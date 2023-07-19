package net.karl.spookage.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.karl.spookage.SpookageMod;
import net.karl.spookage.item.custom.ModAxeItem;
import net.karl.spookage.item.custom.ModHoeItem;
import net.karl.spookage.item.custom.ModPickaxeItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SPOOK_INGOT = registerItem("spook_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_SPOOK = registerItem("raw_spook", new Item(new FabricItemSettings()));
    public static final Item CHARRED_STICK = registerItem("charred_stick", new Item(new FabricItemSettings()));

    //Tools
    public static final Item SPOOK_PICKAXE = registerItem("spook_pickaxe",
            new ModPickaxeItem(SpookToolMaterial.INSTANCE, 0, -2.8f, new Item.Settings()));
    public static final Item SPOOK_AXE = registerItem("spook_axe",
            new ModAxeItem(SpookToolMaterial.INSTANCE, 4, -3f, new Item.Settings()));
    public static final Item SPOOK_SHOVEL = registerItem("spook_shovel",
            new ShovelItem(SpookToolMaterial.INSTANCE, 0.5f, -3f, new Item.Settings()));
    public static  final Item SPOOK_HOE = registerItem("spook_hoe",
            new ModHoeItem(SpookToolMaterial.INSTANCE, -5, 0, new Item.Settings()));
    public static final Item SPOOK_SWORD = registerItem("spook_sword",
            new SwordItem(SpookToolMaterial.INSTANCE, 2, -2.4f, new Item.Settings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(SpookageMod.MOD_ID, name), item);
    }
    //Armor
    public static final Item SPOOK_HELMET = registerItem("spook_helmet",
            new ArmorItem(SpookArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item SPOOK_CHESTPLATE = registerItem("spook_chestplate",
            new ArmorItem(SpookArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item SPOOK_LEGGINGS = registerItem("spook_leggings",
            new ArmorItem(SpookArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item SPOOK_BOOTS = registerItem("spook_boots",
            new ArmorItem(SpookArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings()));





    private static void registeringArmorItems(){

    }

    public static void registerModItems(){
        SpookageMod.LOGGER.info("Registering Mod Items for " + SpookageMod.MOD_ID);

    }
}
