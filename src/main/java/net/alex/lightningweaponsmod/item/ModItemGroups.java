package net.alex.lightningweaponsmod.item;

import net.alex.lightningweaponsmod.LightningWeaponsMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup LIGHTNING = Registry.register(Registries.ITEM_GROUP, new Identifier(LightningWeaponsMod.MOD_ID, "lightning"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.lightning"))
                    .icon(() -> new ItemStack(Items.LIGHTNING_ROD)).entries((displayContext, entries) -> {

                        entries.add(ModItems.LIGHTNING_STICK);
                        entries.add(ModItems.LIGHTNING_SWORD);
                    }).build());

    public static void registerItemGroups() {
        LightningWeaponsMod.LOGGER.info("Registering Item Groups for " + LightningWeaponsMod.MOD_ID);
    }
}
