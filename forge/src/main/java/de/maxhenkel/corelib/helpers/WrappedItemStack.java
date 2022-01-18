package de.maxhenkel.corelib.helpers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.fabricmc.api.Environment;


import java.util.List;

public class WrappedItemStack extends AbstractStack<ItemStack> {

    public WrappedItemStack(ItemStack stack) {
        super(stack);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void render(PoseStack matrixStack, int x, int y) {
        Minecraft.getInstance().getItemRenderer().renderAndDecorateItem(Minecraft.getInstance().player, stack, x, y, 0);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public List<Component> getTooltip(Screen screen) {
        return screen.getTooltipFromItem(stack);
    }

    @Override
    public Component getDisplayName() {
        return stack.getHoverName();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
