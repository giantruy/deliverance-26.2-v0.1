package net.gy.quest.entity;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.illager.Evoker;
import net.minecraft.world.entity.monster.illager.Illusioner;
import net.minecraft.world.entity.monster.illager.Pillager;
import net.minecraft.world.entity.monster.illager.Vindicator;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class ShatterguardEntity extends Monster {
    public ShatterguardEntity(Level world) {
        this(ModEntityTypes.SHATTERGUARD, world);
    }

    public ShatterguardEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
        this.xpReward = 10;
    }

    @Override
    protected void populateDefaultEquipmentSlots(final RandomSource random, final DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(random, difficulty);
        if (random.nextFloat() < (this.level().getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
            int rand = random.nextInt(6);
            if (rand == 0) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
            } else if (rand == 1) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SPEAR));
            } else {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SHOVEL));
            }
        }
    }

    @Override
    protected SoundEvent getHurtSound(final DamageSource source) {
        if (this.level().isClientSide()) {
            ((ClientLevel) this.level())
                    .addParticle(
                    new BlockParticleOption(ParticleTypes.FALLING_DUST, Blocks.SAND.defaultBlockState()),
                    this.getX() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                    this.getY() + this.getBbHeight() / 2,
                    this.getZ() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                    0, -0.1, 0);
            ((ClientLevel) this.level())
                    .addParticle(
                            new BlockParticleOption(ParticleTypes.FALLING_DUST, Blocks.GRAVEL.defaultBlockState()),
                            this.getX() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            this.getY() + this.getBbHeight() / 2,
                            this.getZ() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            0, -0.1, 0);
            ((ClientLevel) this.level())
                    .addParticle(
                            new BlockParticleOption(ParticleTypes.FALLING_DUST, Blocks.SAND.defaultBlockState()),
                            this.getX() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            this.getY() + this.getBbHeight() / 2,
                            this.getZ() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            0, -0.1, 0);
            ((ClientLevel) this.level())
                    .addParticle(
                            new BlockParticleOption(ParticleTypes.FALLING_DUST, Blocks.GRAVEL.defaultBlockState()),
                            this.getX() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            this.getY() + this.getBbHeight() / 2,
                            this.getZ() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            0, -0.1, 0);
        }
        return SoundEvents.DEEPSLATE_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        if (this.level().isClientSide()) {
            ((ClientLevel) this.level()).addParticle(
                    new BlockParticleOption(ParticleTypes.FALLING_DUST, Blocks.SAND.defaultBlockState()),
                    this.getX() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                    this.getY() + this.getBbHeight() / 2,
                    this.getZ() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                    0, 0, 0
            );
        }

        return SoundEvents.DEEPSLATE_BREAK;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.GRINDSTONE_USE;
    }

    @Override
    public boolean wantsToPickUp(final ServerLevel level, final ItemStack itemStack) {
        return itemStack.is(Items.GLOW_INK_SAC) ? false : super.wantsToPickUp(level, itemStack);
    }

    public static AttributeSupplier.Builder createCubeAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 75)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 10)
                .add(Attributes.ARMOR, 6)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 0)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 1.0);
    }


//    public Identifier getDLootTable() {
//        return Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "entities/shatterguard");
//    }

    @Override
    public void tick() {
        super.tick();

//        if (this.level().isClientSide()) {
//            double x = this.getX();
//            double y = this.getY() + this.getBbHeight() / 2;
//            double z = this.getZ();
//
//            this.level().addParticle(
//                    ParticleTypes.,
//                    x + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
//                    y,
//                    z + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
//                    0, 0, 0
//            );
//        }
    }

    @Override
    public void die(DamageSource source) {
        if (!this.level().isClientSide()) {
            this.level().explode(
                    this,
                    this.getX() + this.getBbWidth() / 2,
                    this.getY() + this.getBbHeight() / 2,
                    this.getZ() + this.getBbWidth() / 2,
                    1.5f,
                    false,
                    Level.ExplosionInteraction.NONE
            );

        }

        if (this.level().isClientSide()) {
            ((ClientLevel) this.level())
                    .addParticle(
                            new BlockParticleOption(ParticleTypes.BLOCK_CRUMBLE, Blocks.SAND.defaultBlockState()),
                            this.getX() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            this.getY() + this.getBbHeight() / 2,
                            this.getZ() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            0.2, 0.2, 0.2);
            ((ClientLevel) this.level())
                    .addParticle(
                            new BlockParticleOption(ParticleTypes.FALLING_DUST, Blocks.GRAVEL.defaultBlockState()),
                            this.getX() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            this.getY() + this.getBbHeight() / 2,
                            this.getZ() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            0.2, 0.2, 0.2);
            ((ClientLevel) this.level())
                    .addParticle(
                            new BlockParticleOption(ParticleTypes.FALLING_DUST, Blocks.SAND.defaultBlockState()),
                            this.getX() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            this.getY() + this.getBbHeight() / 2,
                            this.getZ() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            0.2, 0.2, 0.2);
            ((ClientLevel) this.level())
                    .addParticle(
                            new BlockParticleOption(ParticleTypes.FALLING_DUST, Blocks.GRAVEL.defaultBlockState()),
                            this.getX() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            this.getY() + this.getBbHeight() / 2,
                            this.getZ() + (this.random.nextDouble() - 0.5) * this.getBbWidth(),
                            0.2, 0.2, 0.2);
        }
        super.die(source);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Ravager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Evoker.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Pillager.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Vindicator.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Illusioner.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Vex.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
    }

}
