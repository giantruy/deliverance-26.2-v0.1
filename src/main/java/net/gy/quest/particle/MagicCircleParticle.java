package net.gy.quest.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class MagicCircleParticle extends SingleQuadParticle {

    protected MagicCircleParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet) {
        super(level, x, y, z, spriteSet.get(0, 1));
        this.xd = 0.0;
        this.yd = 0.0;
        this.zd = 0.0;
        this.quadSize = 0.5f;
        this.lifetime = 100;
        this.hasPhysics = false;
        this.roll = 0.0f;
        this.oRoll = 0.0f;
    }

    @Override
    public void tick() {
        super.tick();
        this.oRoll = this.roll;
        this.roll += 0.01f;
    }

    @Override
    protected Layer getLayer() {
        return Layer.TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double vx, double vy, double vz, RandomSource source) {
            return new MagicCircleParticle(level, x, y, z, spriteSet);
        }
    }

    @Override
    public FacingCameraMode getFacingCameraMode() {
        return ((target, camera, partialTickTime) -> target.identity().rotateX((float) -Math.PI / 2));
    }

}
