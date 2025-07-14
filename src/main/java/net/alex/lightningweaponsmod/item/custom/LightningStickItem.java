package net.alex.lightningweaponsmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.predicate.entity.LightningBoltPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.tick.Tick;

public class LightningStickItem extends Item {
    public LightningStickItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            PlayerEntity player = context.getPlayer();
            BlockPos pos = context.getBlockPos();
            BlockState state = context.getWorld().getBlockState(pos);
            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, context.getWorld());
            lightning.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
            context.getWorld().spawnEntity(lightning);
        }

        return ActionResult.SUCCESS;
    }

}
