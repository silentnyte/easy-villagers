package de.maxhenkel.easyvillagers.forge.items.render;

import de.maxhenkel.easyvillagers.forge.blocks.ModBlocks;
import de.maxhenkel.easyvillagers.forge.blocks.tileentity.BreederTileentity;
import de.maxhenkel.easyvillagers.forge.blocks.tileentity.render.BreederRenderer;
import net.minecraft.core.BlockPos;

public class BreederItemRenderer extends BlockItemRendererBase<BreederRenderer, BreederTileentity> {

    public BreederItemRenderer() {
        super(BreederRenderer::new, () -> new BreederTileentity(BlockPos.ZERO, ModBlocks.BREEDER.defaultBlockState()));
    }

}
