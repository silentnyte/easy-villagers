package de.maxhenkel.easyvillagers.forge.blocks.tileentity;

import de.maxhenkel.easyvillagers.forge.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TraderTileentity extends TraderTileentityBase {

    public TraderTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.TRADER, ModBlocks.TRADER.defaultBlockState(), pos, state);
    }

}
