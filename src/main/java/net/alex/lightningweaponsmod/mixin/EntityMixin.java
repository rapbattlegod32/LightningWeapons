package net.alex.lightningweaponsmod.mixin;

import net.alex.lightningweaponsmod.event.LightningArmorEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Inject(method = "onStruckByLightning", at = @At("HEAD"), cancellable = true)
    private void lightningWeapons$skipForLightningArmor(ServerWorld world, LightningEntity lightning, CallbackInfo ci) {
        Entity self = (Entity) (Object) this;
        if (self instanceof PlayerEntity player && LightningArmorEffects.isWearingLightning(player)) {
            ci.cancel();
        }
    }
}
