package net.alex.lightningweaponsmod;

import net.alex.lightningweaponsmod.block.ModBlocks;
import net.alex.lightningweaponsmod.item.ModItemGroups;
import net.alex.lightningweaponsmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LightningWeaponsMod implements ModInitializer {
	public static final String MOD_ID = "lightningweapons";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
	}
}