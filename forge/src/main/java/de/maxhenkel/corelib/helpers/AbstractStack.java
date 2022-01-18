package de.maxhenkel.corelib.helpers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.fabricmc.api.Environment;


import java.util.List;

public abstract class AbstractStack<T> {

    protected T stack;

    public AbstractStack(T stack) {
        this.stack = stack;
    }

    @Environment(EnvType.CLIENT)
    public abstract void render(PoseStack matrixStack, int x, int y);

    @Environment(EnvType.CLIENT)
    public abstract List<Component> getTooltip(Screen screen);

    public abstract Component getDisplayName();

    public abstract boolean isEmpty();
}
