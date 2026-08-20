package net.gy.quest.world;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtIo;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

import java.io.File;
import java.io.IOException;

public class ClassicSpawnState extends SavedData {

    private boolean generated = false;

    public boolean hasGenerated() {
        return generated;
    }

    public void setGenerated(boolean value) {
        this.generated = value;
        setDirty();
    }

    public void save(ServerLevel level) {
        if (!isDirty()) return;
        try {
            File file = getSaveFile(level);
            file.getParentFile().mkdirs();
            CompoundTag tag = new CompoundTag();
            tag.putBoolean("generated", generated);
            NbtIo.write(tag, file.toPath());
            setDirty(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ClassicSpawnState load(ServerLevel level) {
        ClassicSpawnState state = new ClassicSpawnState();
        File file = getSaveFile(level);
        if (!file.exists()) return state;
        try {
            CompoundTag tag = NbtIo.read(file.toPath());
            if (tag != null) {
                state.generated = tag.getBoolean("generated").orElse(false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return state;
    }

    private static File getSaveFile(ServerLevel level) {
        return new File(level.getServer().getWorldPath(
                net.minecraft.world.level.storage.LevelResource.ROOT).toFile(),
                "data/classic_spawn.dat"
        );
    }
}