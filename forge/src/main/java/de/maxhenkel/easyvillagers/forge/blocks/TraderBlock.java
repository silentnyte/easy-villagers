package de.maxhenkel.easyvillagers.forge.blocks;

import de.maxhenkel.easyvillagers.EasyVillagers;
import de.maxhenkel.corelib.client.CustomRendererBlockItem;
import de.maxhenkel.corelib.client.ItemRenderer;
import de.maxhenkel.easyvillagers.forge.blocks.tileentity.TraderTileentity;
import de.maxhenkel.easyvillagers.forge.blocks.tileentity.TraderTileentityBase;
import de.maxhenkel.easyvillagers.forge.entity.EasyVillagerEntity;
import de.maxhenkel.easyvillagers.forge.EasyVillagersForge;
import de.maxhenkel.easyvillagers.forge.ItemTileEntityCache;
import de.maxhenkel.easyvillagers.forge.ModItemGroups;
import de.maxhenkel.easyvillagers.forge.items.render.TraderItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class TraderBlock extends TraderBlockBase {

    public TraderBlock() {
        setRegistryName(new ResourceLocation(EasyVillagers.MOD_ID, "trader"));
    }

    @Override
    public Item toItem() {
        return new CustomRendererBlockItem(this, new Item.Properties().tab(ModItemGroups.TAB_EASY_VILLAGERS)) {
            @OnlyIn(Dist.CLIENT)
            @Override
            public ItemRenderer createItemRenderer() {
                return new TraderItemRenderer();
            }
        }.setRegistryName(getRegistryName());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter blockGetter, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, blockGetter, components, tooltipFlag);
        TraderTileentity trader = ItemTileEntityCache.getTileEntity(stack, () -> new TraderTileentity(BlockPos.ZERO, ModBlocks.TRADER.defaultBlockState()));
        EasyVillagerEntity villager = trader.getVillagerEntity();
        if (villager != null) {
            components.add(villager.getAdvancedName());
        }
    }

    @Override
    protected boolean openGUI(TraderTileentityBase trader, Player player) {
        return trader.openTradingGUI(player);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TraderTileentity(blockPos, blockState);
    }

}
