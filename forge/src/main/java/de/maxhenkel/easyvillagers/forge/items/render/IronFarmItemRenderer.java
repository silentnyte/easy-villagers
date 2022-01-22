package de.maxhenkel.easyvillagers.forge.items.render;

import de.maxhenkel.easyvillagers.forge.blocks.ModBlocks;
import de.maxhenkel.easyvillagers.forge.blocks.tileentity.IronFarmTileentity;
import de.maxhenkel.easyvillagers.forge.blocks.tileentity.render.IronFarmRenderer;
import net.minecraft.core.BlockPos;

public class IronFarmItemRenderer extends BlockItemRendererBase<IronFarmRenderer, IronFarmTileentity> {

    public IronFarmItemRenderer() {
        super(IronFarmRenderer::new, () -> new IronFarmTileentity(BlockPos.ZERO, ModBlocks.IRON_FARM.defaultBlockState()));
    }

}
