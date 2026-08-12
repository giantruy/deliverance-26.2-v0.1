package net.gy.quest.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.gy.quest.Deliverance;
import net.gy.quest.sound.ModSounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModSoundsProvider extends FabricSoundsProvider {

    public ModSoundsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registryLookup, SoundExporter exporter) {
        exporter.add(ModSounds.DOWNED, SoundTypeBuilder.of(ModSounds.DOWNED.value())
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(Deliverance.MOD_ID, "downed")).stream(true)));
    }

    @Override
    public String getName() {
        return "Deliverance Sounds";
    }
}
