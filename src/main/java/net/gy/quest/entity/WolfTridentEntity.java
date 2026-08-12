package net.gy.quest.entity;

import net.gy.quest.effect.ModEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class WolfTridentEntity extends ThrownTrident {
    public WolfTridentEntity(EntityType<? extends WolfTridentEntity> type, Level level) {
        super(type, level);
    }

    public WolfTridentEntity(Level level, LivingEntity owner, ItemStack stack) {
        super(ModEntityTypes.WOLF_TRIDENT, level);
        this.setOwner(owner);
        this.setPickupItemStack(stack);
        this.setPos(owner.getX(), owner.getEyeY() - 0.1, owner.getZ());
        this.setXRot(owner.getXRot());
        this.setYRot(owner.getYRot());
        this.shootFromRotation(owner, owner.getXRot(), owner.getYRot(), 0.0f, 2.5f, 1.0f);
    }

    public WolfTridentEntity(Level level, double x, double y, double z, ItemStack stack) {
        super(ModEntityTypes.WOLF_TRIDENT, level);
        this.setPickupItemStack(stack);
        this.setPos(x, y, z);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
    }

    @Override
    protected void doPostHurtEffects(LivingEntity target) {
        super.doPostHurtEffects(target);
        if (!this.level().isClientSide()) {
            target.addEffect(new net.minecraft.world.effect.MobEffectInstance(ModEffects.BLOODLETTING, 100, 0));
        }
    }

//    @Override
//    public boolean shouldReturnToOwner() {
//        return true;
//    }

    @Override
    public void tick() {
        super.tick();

        if (!(this.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        int loyalty = EnchantmentHelper.getTridentReturnToOwnerAcceleration(serverLevel, this.getPickupItemStackOrigin(), this);

        if (loyalty > 0 && this.getOwner() instanceof LivingEntity owner) {
            if (!owner.isAlive()) {
                return;
            }
            this.setNoPhysics(true);
            Vec3 vec3 = owner.getEyePosition().subtract(this.position());
            this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.015d * loyalty, this.getZ());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.95d).add(vec3.normalize().scale(0.05d * loyalty)));
        }
    }
}