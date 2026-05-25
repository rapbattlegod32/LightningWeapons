package net.alex.lightningweaponsmod.event;

import net.alex.lightningweaponsmod.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public final class LightningArmorEffects {
    private LightningArmorEffects() {}

    public static boolean isWearingLightning(PlayerEntity player) {
        for (ItemStack stack : player.getArmorItems()) {
            if (stack.getItem() instanceof ArmorItem armor && armor.getMaterial() == ModArmorMaterials.LIGHTNING) {
                return true;
            }
        }
        return false;
    }

    public static void retaliate(PlayerEntity wearer, DamageSource source) {
        World world = wearer.getWorld();
        if (world.isClient) return;
        if (!isWearingLightning(wearer)) return;

        Entity attacker = source.getAttacker();
        if (!(attacker instanceof LivingEntity) || attacker == wearer) return;

        LightningEntity bolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        bolt.setPos(attacker.getX(), attacker.getY(), attacker.getZ());
        world.spawnEntity(bolt);
    }
}
