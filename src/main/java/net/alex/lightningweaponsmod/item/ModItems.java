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

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(LIGHTNING_STICK);
        entries.add(LIGHTNING_SWORD);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(LightningWeaponsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LightningWeaponsMod.LOGGER.info("Registering mod items for " + LightningWeaponsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
