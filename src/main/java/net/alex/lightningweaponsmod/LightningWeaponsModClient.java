package net.alex.lightningweaponsmod;

import net.alex.lightningweaponsmod.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;

public class LightningWeaponsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicates.registerModelPredicates();
    }
}
