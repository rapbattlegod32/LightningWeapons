package net.alex.lightningweaponsmod.item;

import net.alex.lightningweaponsmod.LightningWeaponsMod;
import net.alex.lightningweaponsmod.item.custom.LightningStickItem;
import net.alex.lightningweaponsmod.item.custom.LightningSworditem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item LIGHTNING_STICK = registerItem("lightning_stick", new LightningStickItem(new FabricItemSettings()));

    public static final Item LIGHTNING_SWORD = registerItem("lightning_sword",
            new LightningSworditem(ModToolMaterial.LIGHTNING, 10, 3f, new FabricItemSettings()));

    public static final Item LIGHTNING_BOW = registerItem("lightning_bow",
            new BowItem(new Item.Settings().maxDamage(500)));

    public static final Item LIGHTNING_HELMET = registerItem("lightning_helmet",
            new ArmorItem(ModArmorMaterials.LIGHTNING, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item LIGHTNING_CHESTPLATE = registerItem("lightning_chestplate",
            new ArmorItem(ModArmorMaterials.LIGHTNING, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item LIGHTNING_LEGGINGS = registerItem("lightning_leggings",
            new ArmorItem(ModArmorMaterials.LIGHTNING, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item LIGHTNING_BOOTS = registerItem("lightning_boots",
            new ArmorItem(ModArmorMaterials.LIGHTNING, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(LIGHTNING_STICK);
        entries.add(LIGHTNING_SWORD);
        entries.add(LIGHTNING_BOW);
        entries.add(LIGHTNING_HELMET);
        entries.add(LIGHTNING_CHESTPLATE);
        entries.add(LIGHTNING_LEGGINGS);
        entries.add(LIGHTNING_BOOTS);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(LightningWeaponsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LightningWeaponsMod.LOGGER.info("Registering mod items for " + LightningWeaponsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
