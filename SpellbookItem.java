package com.invokermod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SpellbookItem extends Item {
    public SpellbookItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world instanceof ServerWorld sw && user instanceof ServerPlayerEntity sp) {
            if (InvokerManager.cast(sp, sw)) {
                sp.getItemCooldownManager().set(user.getStackInHand(hand), Spells.BOOK_COOLDOWN);
            }
        }
        return ActionResult.SUCCESS;
    }
}
