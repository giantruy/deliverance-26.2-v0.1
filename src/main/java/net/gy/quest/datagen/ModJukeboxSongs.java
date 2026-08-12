package net.gy.quest.datagen;

import net.gy.quest.Deliverance;
import net.gy.quest.sound.ModSounds;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.item.JukeboxSong;

public class ModJukeboxSongs {

    public static final ResourceKey<JukeboxSong> DOWNED_KEY = ResourceKey.create(Registries.JUKEBOX_SONG,
            Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "downed"));

    public static void bootstrap(BootstrapContext<JukeboxSong> context) {
        register(context, DOWNED_KEY, ModSounds.DOWNED, 153, 13);
    }

    private static void register(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key, Holder.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput) {
        context.register(key, new JukeboxSong(soundEvent,
                Component.translatable(Util.makeDescriptionId(
                "jukebox_song", key.identifier())),
                lengthInSeconds, comparatorOutput));
    }
}
