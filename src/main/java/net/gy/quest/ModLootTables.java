package net.gy.quest;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModLootTables {
    public static ResourceKey<LootTable> CURSED_CHEST_LOOT = ResourceKey.create(Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "chests/cursed_loot"));
    public static ResourceKey<LootTable> FANG_CHEST_LOOT = ResourceKey.create(Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "chests/fang_loot"));
    public static ResourceKey<LootTable> RUINS_CHEST_LOOT = ResourceKey.create(Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "chests/ruins_loot"));
}
