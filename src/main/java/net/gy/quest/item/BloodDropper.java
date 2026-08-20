package net.gy.quest.item;

import net.gy.quest.entity.ModEntityTypes;
import net.gy.quest.entity.SummonedSkeletonEntity;
import net.gy.quest.entity.SummonedZombieEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class BloodDropper extends Item {

    public BloodDropper(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            DifficultyInstance difficulty = serverLevel.getCurrentDifficultyAt(player.blockPosition());

            for (int i = 0; i < 2; i++) {
                SummonedZombieEntity zombie = ModEntityTypes.SUMMONED_ZOMBIE.create(serverLevel, EntitySpawnReason.MOB_SUMMONED);
                if (zombie != null) {
                    zombie.setPos(player.getX(), player.getY(), player.getZ());
                    zombie.setSummoner(player);
                    zombie.finalizeSpawn(serverLevel, difficulty, EntitySpawnReason.MOB_SUMMONED, null);
                    serverLevel.addFreshEntity(zombie);
                }

                SummonedSkeletonEntity skeleton = ModEntityTypes.SUMMONED_SKELETON.create(serverLevel, EntitySpawnReason.MOB_SUMMONED);
                if (skeleton != null) {
                    skeleton.setPos(player.getX(), player.getY(), player.getZ());
                    skeleton.setSummoner(player);
                    skeleton.finalizeSpawn(serverLevel, difficulty, EntitySpawnReason.MOB_SUMMONED, null);
                    serverLevel.addFreshEntity(skeleton);
                }
            }
        }

        return InteractionResult.SUCCESS;
    }
}