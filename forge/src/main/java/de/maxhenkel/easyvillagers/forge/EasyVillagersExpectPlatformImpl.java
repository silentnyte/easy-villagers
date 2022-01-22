package de.maxhenkel.easyvillagers.forge;

import de.maxhenkel.easyvillagers.EasyVillagersExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class EasyVillagersExpectPlatformImpl {
    /**
     * This is our actual method to {@link EasyVillagersExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
