package de.maxhenkel.easyvillagers.forge.items.render;

import de.maxhenkel.easyvillagers.forge.blocks.ModBlocks;
import de.maxhenkel.easyvillagers.forge.blocks.tileentity.IncubatorTileentity;
import de.maxhenkel.easyvillagers.forge.blocks.tileentity.render.IncubatorRenderer;
import net.minecraft.core.BlockPos;

public class IncubatorItemRenderer extends BlockItemRendererBase<IncubatorRenderer, IncubatorTileentity> {

    public IncubatorItemRenderer() {
        super(IncubatorRenderer::new, () -> new IncubatorTileentity(BlockPos.ZERO, ModBlocks.INCUBATOR.defaultBlockState()));
    }

}
