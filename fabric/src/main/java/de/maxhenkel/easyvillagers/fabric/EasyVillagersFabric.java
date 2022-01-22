package de.maxhenkel.easyvillagers.fabric;

import de.maxhenkel.easyvillagers.EasyVillagers;
import net.fabricmc.api.ModInitializer;

public class EasyVillagersFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        EasyVillagers.init();
    }
}
