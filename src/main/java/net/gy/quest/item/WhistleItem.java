package net.gy.quest.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class WhistleItem extends Item {

    public WhistleItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            boolean hasExistingWolves = !serverLevel.getEntitiesOfClass(
                    Wolf.class,
                    player.getBoundingBox().inflate(128),
                    wolf -> wolf.isOwnedBy(player) && wolf.isAlive() && wolf.getMaxHealth() == 30.0f
            ).isEmpty();

            if (!hasExistingWolves) {
                EntityType<?> wolfType = BuiltInRegistries.ENTITY_TYPE.getValue(Identifier.fromNamespaceAndPath("minecraft", "wolf"));
                if (wolfType != null) {
                    for (int i = 0; i < 1; i++) {
                        Wolf wolf = (Wolf) wolfType.create(serverLevel, EntitySpawnReason.MOB_SUMMONED);
                        if (wolf != null) {
                            wolf.setPos(player.getX(), player.getY(), player.getZ());
                            wolf.tame(player);
                            wolf.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30.0);
                            wolf.setHealth(40.0f);
                            wolf.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(1.0);
                            serverLevel.addFreshEntity(wolf);
                        }
                    }
                }
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.SUCCESS;
    }
}
