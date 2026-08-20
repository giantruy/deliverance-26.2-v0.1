package net.gy.quest.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;

public class RiftKey extends Item {
    public RiftKey(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            ServerLevel serverLevel = (ServerLevel) level;
            ServerLevel classic = serverLevel.getServer().getLevel(
                    ResourceKey.create(Registries.DIMENSION,
                            Identifier.fromNamespaceAndPath("quest", "classic"))
            );

            if (classic != null) {
                serverPlayer.teleport(new TeleportTransition(
                        classic,
                        new Vec3(0.5, 81, 0.5),
                        Vec3.ZERO,
                        serverPlayer.getYRot(),
                        serverPlayer.getXRot(),
                        TeleportTransition.DO_NOTHING
                ));
            }
        }

        return InteractionResult.SUCCESS;
    }
}