package net.gy.quest.item;

import net.gy.quest.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class RedstoneHammer extends MaceItem {
    public RedstoneHammer(Properties properties) {
        super(properties);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity mob, LivingEntity attacker) {
        mob.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 100, 2));
        mob.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 40, 1));
        mob.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 1));
        super.hurtEnemy(stack, mob, attacker);
    }
}
