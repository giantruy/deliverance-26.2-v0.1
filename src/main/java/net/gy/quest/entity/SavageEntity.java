package net.gy.quest.entity;

import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.Level;

public class SavageEntity extends Zombie {
    public SavageEntity(Level world) {
        this(ModEntityTypes.SAVAGE, world);
    }

    public SavageEntity(EntityType<? extends Zombie> entityType, Level world) {
        super(entityType, world);
        this.xpReward = 10;
    }

    public static AttributeSupplier.Builder createCubeAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5)
                .add(Attributes.MOVEMENT_SPEED, 0.4)
                .add(Attributes.ATTACK_DAMAGE, 7)
                .add(Attributes.ARMOR, 5.0)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 75)
                .add(Attributes.JUMP_STRENGTH, 0.5);
    }

    @Override
    public void setBaby(boolean baby) {
        super.setBaby(false);
    }

    public void die(DamageSource source) {
        super.die(source);
    }
}
