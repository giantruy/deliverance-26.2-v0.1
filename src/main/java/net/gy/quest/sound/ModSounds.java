package net.gy.quest.sound;

import net.gy.quest.Deliverance;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {

    public static final Holder.Reference<SoundEvent> DOWNED = registerJukeboxSong("downed");

    private static Holder.Reference<SoundEvent> registerJukeboxSong(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, name);
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }


    public static void registerModSounds() {
        Deliverance.LOGGER.info("Registering Mod Sounds for " + Deliverance.MOD_ID);
    }
}
