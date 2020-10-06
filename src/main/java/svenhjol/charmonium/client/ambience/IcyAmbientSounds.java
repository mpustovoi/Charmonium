package svenhjol.charmonium.client.ambience;

import net.minecraft.client.sound.SoundManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.biome.Biome;
import svenhjol.charm.module.PlayerState;
import svenhjol.charmonium.base.CharmoniumSounds;
import svenhjol.charmonium.iface.IBiomeAmbience;

import javax.annotation.Nullable;

public class IcyAmbientSounds {
    public static class Day extends BaseAmbientSounds implements IBiomeAmbience {
        public Day(PlayerEntity player, SoundManager soundHandler) {
            super(player, soundHandler);
        }

        @Nullable
        @Override
        public SoundEvent getLongSound() {
            return CharmoniumSounds.AMBIENCE_ICY_DAY_LONG;
        }

        @Nullable
        @Override
        public SoundEvent getShortSound() {
            return CharmoniumSounds.AMBIENCE_ICY_DAY_SHORT;
        }

        @Override
        public int getShortSoundDelay() {
            return world.random.nextInt(400) + 500;
        }

        @Override
        public boolean validBiomeConditions(Biome.Category biomeCategory) {
            return biomeCategory == Biome.Category.ICY
                && PlayerState.client.isDaytime
                && isOutside();
        }
    }

    public static class Night extends BaseAmbientSounds implements IBiomeAmbience {
        public Night(PlayerEntity player, SoundManager soundHandler) {
            super(player, soundHandler);
        }

        @Nullable
        @Override
        public SoundEvent getLongSound() {
            return CharmoniumSounds.AMBIENCE_ICY_NIGHT_LONG;
        }

        @Override
        public boolean validBiomeConditions(Biome.Category biomeCategory) {
            return biomeCategory == Biome.Category.ICY
                && isOutside()
                && !PlayerState.client.isDaytime;
        }
    }
}