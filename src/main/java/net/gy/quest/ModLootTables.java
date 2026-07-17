package net.gy.quest;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModLootTables {
    public static ResourceKey<LootTable> CURSED_CHEST_LOOT = ResourceKey.create(Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "chests/cursed_loot"));
}
