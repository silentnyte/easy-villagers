package de.maxhenkel.corelib.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;
import net.fabricmc.api.Environment;


public class ItemRenderer {

    @Environment(EnvType.CLIENT)
    protected Minecraft minecraft = Minecraft.getInstance();
    @Environment(EnvType.CLIENT)
    private final Renderer renderer = new Renderer();

    @Environment(EnvType.CLIENT)
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {

    }

    @Environment(EnvType.CLIENT)
    protected Renderer getRenderer() {
        return renderer;
    }

    @Environment(EnvType.CLIENT)
    protected class Renderer extends BlockEntityWithoutLevelRenderer {

        public Renderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {
            ItemRenderer.this.renderByItem(stack, transformType, poseStack, multiBufferSource, light, overlay);
        }
    }

}
