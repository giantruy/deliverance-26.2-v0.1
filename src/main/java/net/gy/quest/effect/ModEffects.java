package net.gy.quest.effect;

import net.gy.quest.Deliverance;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ModEffects {

    public static final Identifier ELECTROCUTED_SLOW_ID = Identifier.fromNamespaceAndPath("quest", "effect.electrocuted");

    public static final Holder<MobEffect> ELECTROCUTED = registerEffect("electrocuted", new MobEffect(MobEffectCategory.HARMFUL, 0x3B9DFF) {

        @Override
        public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
            return true;
        }

        public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
            float damage = 0.5F + amplifier;
            if (entity.isUnderWater()) {
                damage *= 2.0;
            } else if (entity.isInWaterOrRain()) {
                damage *= 1.5;
            }
            entity.hurt(entity.damageSources().magic(), damage);
            return super.applyEffectTick(level, entity, amplifier);
        }

    }
                    .addAttributeModifier(
                        Attributes.MOVEMENT_SPEED,
                        ELECTROCUTED_SLOW_ID,
                        -1.0,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                    )
                    .addAttributeModifier(
                            Attributes.JUMP_STRENGTH,
                            ELECTROCUTED_SLOW_ID,
                            -1.0,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                    )
                    .addAttributeModifier(
                            Attributes.KNOCKBACK_RESISTANCE,
                            ELECTROCUTED_SLOW_ID,
                            3.0,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                    )

    );

    private static Holder<MobEffect> registerEffect(String name, MobEffect effect) {
        ResourceKey<MobEffect> key = ResourceKey.create(
                Registries.MOB_EFFECT,
                Identifier.fromNamespaceAndPath("quest", name)
        );
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, key, effect);
    }

    public static void registerModEffects() {
        Deliverance.LOGGER.info("Registering Mod Effects for " + Deliverance.MOD_ID);
    }
}
