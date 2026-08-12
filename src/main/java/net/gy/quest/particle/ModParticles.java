package net.gy.quest.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.gy.quest.Deliverance;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class ModParticles {

    public static final SimpleParticleType MAGIC_CIRCLE =
            Registry.register(BuiltInRegistries.PARTICLE_TYPE,
                    Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "magic_circle"),
                    FabricParticleTypes.simple());

    public static void registerModParticles() {
        Deliverance.LOGGER.info("Registering Mod Particles for " + Deliverance.MOD_ID);
    }
}
