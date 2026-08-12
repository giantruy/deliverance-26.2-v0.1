package net.gy.quest.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.gy.quest.Deliverance;
import net.gy.quest.entity.ModEntityTypes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;

public class ModEntitySpawn {
    public static void registerModEntitySpawns() {
        SpawnPlacements.register(
                ModEntityTypes.SAVAGE,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(Biomes.DRIPSTONE_CAVES),
                MobCategory.MONSTER,
                ModEntityTypes.SAVAGE,
                80, 1, 4
        );

        Deliverance.LOGGER.info("Registering Mod Entity Spawns for " + Deliverance.MOD_ID);
    }
}