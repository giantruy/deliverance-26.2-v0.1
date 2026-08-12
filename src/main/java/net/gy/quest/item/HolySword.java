package net.gy.quest.item;

import net.gy.quest.entity.ModEntityTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HolySword extends Item{
    public HolySword(Item.Properties properties) {
        super(properties);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity mob, LivingEntity attacker) {
        if (mob.is(EntityTypeTags.UNDEAD)) {
            mob.igniteForTicks(60);
        } else if (mob.is(EntityTypeTags.ILLAGER) || mob.is(EntityTypeTags.ILLAGER_FRIENDS)) {
            mob.igniteForTicks(60);
        }
//        else if (mob.is(ModEntityTypes.SAVAGE)) {
//            mob.igniteForTicks(60);
//        }
        super.hurtEnemy(stack, mob, attacker);
    }
}
