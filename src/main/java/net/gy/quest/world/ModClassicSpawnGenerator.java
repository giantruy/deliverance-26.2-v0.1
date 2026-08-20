package net.gy.quest.world;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLevelEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.gy.quest.Deliverance;
import net.gy.quest.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.saveddata.SavedData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class ModClassicSpawnGenerator {

    private static final ResourceKey<Level> CLASSIC_DIM = ResourceKey.create(
            Registries.DIMENSION,
            Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic")
    );

    private static final Map<UUID, Integer> pendingMessages = new HashMap<>();

    // SavedData that tracks which players have already received the first-entry messages
    public static class ClassicFirstEntryState {

        private static final String FILE_NAME = "quest_classic_first_entry.txt";

        private static File getSaveFile(ServerLevel level) {
            return new File(level.getServer().getWorldPath(
                    net.minecraft.world.level.storage.LevelResource.ROOT).toFile(),
                    "data/" + FILE_NAME
            );
        }

        public static boolean hasSeen(ServerLevel level, UUID uuid) {
            File file = getSaveFile(level);
            if (!file.exists()) return false;
            try {
                for (String line : java.nio.file.Files.readAllLines(file.toPath())) {
                    if (line.trim().equals(uuid.toString())) return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        public static void markSeen(ServerLevel level, UUID uuid) {
            File file = getSaveFile(level);
            file.getParentFile().mkdirs();
            try (var writer = new java.io.FileWriter(file, true)) {
                writer.write(uuid + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void registerGenerator() {
        ServerLevelEvents.LOAD.register((server, level) -> {
            if (level.dimension().equals(CLASSIC_DIM)) {
                ClassicSpawnState state = ClassicSpawnState.load(level);
                if (!state.hasGenerated()) {
                    generatePlatform(level);
                    state.setGenerated(true);
                    state.save(level);
                }
            }
        });

        ServerEntityEvents.ENTITY_LOAD.register((entity, level) -> {
            if (!(entity instanceof ServerPlayer player)) return;
            if (!level.dimension().equals(CLASSIC_DIM)) return;

            ServerLevel classicLevel = (ServerLevel) level;
            if (!ClassicFirstEntryState.hasSeen(classicLevel, player.getUUID())) {
                pendingMessages.put(player.getUUID(), 0);
            }
        });

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            pendingMessages.replaceAll((uuid, ticks) -> ticks + 1);

            pendingMessages.entrySet().removeIf(entry -> {
                int ticks = entry.getValue();
                ServerPlayer player = server.getPlayerList().getPlayer(entry.getKey());
                if (player == null) return true;

                if (ticks == 100) {
                    player.sendSystemMessage(Component.literal("You found me..."));
                } else if (ticks == 130) {
                    player.sendSystemMessage(Component.literal("After all these years... finally free."));
                } else if (ticks == 200) {
                    player.sendSystemMessage(Component.literal("I shall remember you, Player, and as long as you stay out of my path, you shall stay safe."));
                    ServerLevel classicLevel = server.getLevel(CLASSIC_DIM);
                    if (classicLevel != null) {
                        ClassicFirstEntryState.markSeen(classicLevel, entry.getKey());
                    }
                    return true;
                }
                return false;
            });
        });
    }

    private static void generatePlatform(ServerLevel level) {
        BlockPos center = new BlockPos(0, 79, 0);

        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                level.setBlock(center.offset(x, 0, z), ModBlocks.CLASSIC_COBBLESTONE.defaultBlockState(), 3);
            }
        }

        level.setBlock(center.above(), Blocks.CRAFTING_TABLE.defaultBlockState(), 3);
    }
}