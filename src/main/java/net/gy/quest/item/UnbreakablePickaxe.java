package net.gy.quest.item;

import net.gy.quest.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class UnbreakablePickaxe extends Item {
    public UnbreakablePickaxe(Properties properties) {
        super(properties);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity mob, LivingEntity attacker) {
        mob.addEffect(new MobEffectInstance(ModEffects.ELECTROCUTED, 100, 0));
        super.hurtEnemy(stack, mob, attacker);
    }
}
