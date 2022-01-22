package de.maxhenkel.easyvillagers.forge.items.render;

import de.maxhenkel.easyvillagers.forge.blocks.ModBlocks;
import de.maxhenkel.easyvillagers.forge.blocks.tileentity.ConverterTileentity;
import de.maxhenkel.easyvillagers.forge.blocks.tileentity.render.ConverterRenderer;
import net.minecraft.core.BlockPos;

public class ConverterItemRenderer extends BlockItemRendererBase<ConverterRenderer, ConverterTileentity> {

    public ConverterItemRenderer() {
        super(ConverterRenderer::new, () -> new ConverterTileentity(BlockPos.ZERO, ModBlocks.CONVERTER.defaultBlockState()));
    }

}
