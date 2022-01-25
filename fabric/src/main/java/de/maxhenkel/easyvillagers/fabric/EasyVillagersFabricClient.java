package de.maxhenkel.easyvillagers.fabric;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.VillagerRenderer;

public class EasyVillagersFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //BlockEntityRendererRegistry.INSTANCE.register(VILLAGER2, VillagerRenderer::new);
    }
}