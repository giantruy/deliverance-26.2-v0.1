package net.gy.quest.block;

import net.gy.quest.Deliverance;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {

    public static final TreeGrower CLASSIC_OAK = new TreeGrower(
            Deliverance.MOD_ID + "classic_oak",
            Optional.empty(),
            Optional.of(ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "classic_tree")
            )),
            Optional.empty()
    );

}