package net.gy.quest.client;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.gy.quest.Deliverance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;

public class ModEvents {

    public static void registerModEvents() {
        Deliverance.LOGGER.info("Registering Mod Events for " + Deliverance.MOD_ID);
//        ServerTickEvents.END_SERVER_TICK.register(server -> {
//            for (ServerLevel level : server.getAllLevels()) {
//                for (Entity entity : level.getAllEntities()) {
//                    if (entity.tags().anyMatch("blood_dropper_summoned"::equals)
//                            && entity instanceof Mob mob
//                            && mob.getTarget() instanceof Player) {
//                        mob.setTarget(null);
//                    }
//                }
//            }
//        });
    }
}