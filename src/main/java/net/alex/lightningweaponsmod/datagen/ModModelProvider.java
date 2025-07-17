package net.alex.lightningweaponsmod.datagen;

import net.alex.lightningweaponsmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LIGHTNING_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LIGHTNING_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LIGHTNING_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LIGHTNING_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LIGHTNING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LIGHTNING_STICK, Models.HANDHELD);
    }
}
