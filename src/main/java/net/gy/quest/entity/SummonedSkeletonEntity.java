package net.gy.quest.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class SummonedSkeletonEntity extends Skeleton {
    public SummonedSkeletonEntity(Level world) {
        this(ModEntityTypes.SUMMONED_SKELETON, world);
    }

    private UUID summonerUUID;

    public void setSummoner(Player player) {
        this.summonerUUID = player.getUUID();
    }

    public @Nullable Player getSummoner(Level level) {
        if (summonerUUID == null || !(level instanceof ServerLevel serverLevel)) return null;
        return serverLevel.getPlayerByUUID(summonerUUID);
    }

    public SummonedSkeletonEntity(EntityType<? extends Skeleton> entityType, Level world) {
        super(entityType, world);
    }

    public static AttributeSupplier.Builder createCubeAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.1)
                .add(Attributes.MOVEMENT_SPEED, 0.35)
                .add(Attributes.ATTACK_DAMAGE, 1)
                .add(Attributes.ARMOR, 2.0)
                .add(Attributes.JUMP_STRENGTH, 0.5);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.getAvailableGoals().removeIf(goal ->
                goal.getGoal() instanceof NearestAttackableTargetGoal<?>
        );
        this.targetSelector.getAvailableGoals().removeIf(goal ->
                goal.getGoal() instanceof HurtByTargetGoal
        );
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false,
                (target, lvl) -> {
                    if (target instanceof Player) return false;
                    Player summoner = getSummoner(this.level());
                    if (summoner == null) return false;
                    LivingEntity summonerLastHurt = summoner.getLastHurtByMob();
                    return summonerLastHurt != null && summonerLastHurt.getUUID().equals(target.getUUID());
                }
        ));
    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource source, boolean recentlyHit) {
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.LEATHER_LEGGINGS));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
    }

    @Override
    public void tick() {
        this.setFreezeConverting(false);
        super.tick();

        if (!this.level().isClientSide()) {
            Player summoner = getSummoner(this.level());
            if (summoner != null) {
                LivingEntity lastHurt = summoner.getLastHurtByMob();
                if (lastHurt != null && !(lastHurt instanceof Player) && this.getTarget() == null) {
                    this.setTarget(lastHurt);
                }

                LivingEntity summonerTarget = summoner.getLastHurtMob();
                if (summonerTarget != null && !(summonerTarget instanceof Player) && this.getTarget() == null) {
                    this.setTarget(summonerTarget);
                }
            }
        }
    }

    public void die(DamageSource source) {
        super.die(source);
    }
}
