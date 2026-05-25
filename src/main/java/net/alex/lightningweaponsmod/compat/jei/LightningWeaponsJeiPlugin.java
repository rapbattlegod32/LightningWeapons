package net.alex.lightningweaponsmod.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.alex.lightningweaponsmod.LightningWeaponsMod;
import net.alex.lightningweaponsmod.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@JeiPlugin
public class LightningWeaponsJeiPlugin implements IModPlugin {
    private static final Identifier PLUGIN_ID = new Identifier(LightningWeaponsMod.MOD_ID, "jei_plugin");

    @Override
    public Identifier getPluginUid() {
        return PLUGIN_ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        info(registration, ModItems.LIGHTNING_SWORD.getDefaultStack(), "jei.lightningweaponsmod.lightning_sword.desc");
        info(registration, ModItems.LIGHTNING_BOW.getDefaultStack(),   "jei.lightningweaponsmod.lightning_bow.desc");

        String armorKey = "jei.lightningweaponsmod.lightning_armor.desc";
        info(registration, ModItems.LIGHTNING_HELMET.getDefaultStack(),     armorKey);
        info(registration, ModItems.LIGHTNING_CHESTPLATE.getDefaultStack(), armorKey);
        info(registration, ModItems.LIGHTNING_LEGGINGS.getDefaultStack(),   armorKey);
        info(registration, ModItems.LIGHTNING_BOOTS.getDefaultStack(),      armorKey);
    }

    private static void info(IRecipeRegistration registration, ItemStack stack, String translationKey) {
        registration.addIngredientInfo(stack, VanillaTypes.ITEM_STACK, Text.translatable(translationKey));
    }
}
