package net.gy.quest.effect;

import net.gy.quest.Deliverance;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;


public class ModDamageTypes {
    public static final ResourceKey<DamageType> BLOOD = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "blood"));

    public void registerModDamageTypes() {
        Deliverance.LOGGER.info("Registering Mod Damage Types for " + Deliverance.MOD_ID);
    }
}
