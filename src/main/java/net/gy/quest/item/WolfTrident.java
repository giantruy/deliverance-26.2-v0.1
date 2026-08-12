package net.gy.quest.item;

import net.gy.quest.effect.ModEffects;
import net.gy.quest.entity.ModEntityTypes;
import net.gy.quest.entity.WolfTridentEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.Level;

public class WolfTrident extends TridentItem {
    public WolfTrident(Properties properties) {
        super(properties);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity mob, LivingEntity attacker) {
        mob.addEffect(new net.minecraft.world.effect.MobEffectInstance(ModEffects.BLOODLETTING, 100, 0));
        super.hurtEnemy(stack, mob, attacker);
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack stack, Direction direction) {
        WolfTridentEntity trident = new WolfTridentEntity(level, position.x(), position.y(), position.z(), stack.copyWithCount(1));
        trident.setPos(position.x(), position.y(), position.z());
        trident.pickup = AbstractArrow.Pickup.ALLOWED;
        
        return trident;
    }
}
