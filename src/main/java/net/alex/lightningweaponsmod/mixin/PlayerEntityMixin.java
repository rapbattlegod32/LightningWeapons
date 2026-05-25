package net.alex.lightningweaponsmod.mixin;

import net.alex.lightningweaponsmod.event.LightningArmorEffects;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(method = "damage", at = @At("TAIL"))
    private void lightningWeapons$retaliateWithLightning(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (!Boolean.TRUE.equals(cir.getReturnValue())) return;
        LightningArmorEffects.retaliate((PlayerEntity) (Object) this, source);
    }
}
