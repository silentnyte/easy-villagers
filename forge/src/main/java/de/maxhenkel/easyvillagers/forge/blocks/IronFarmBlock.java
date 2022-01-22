package de.maxhenkel.easyvillagers.forge.blocks;

import de.maxhenkel.easyvillagers.EasyVillagers;
import de.maxhenkel.corelib.block.IItemBlock;
import de.maxhenkel.corelib.blockentity.SimpleBlockEntityTicker;
import de.maxhenkel.corelib.client.CustomRendererBlockItem;
import de.maxhenkel.corelib.client.ItemRenderer;
import de.maxhenkel.corelib.item.ItemUtils;
import de.maxhenkel.easyvillagers.forge.blocks.tileentity.IronFarmTileentity;
import de.maxhenkel.easyvillagers.forge.entity.EasyVillagerEntity;
import de.maxhenkel.easyvillagers.forge.EasyVillagersForge;
import de.maxhenkel.easyvillagers.forge.ItemTileEntityCache;
import de.maxhenkel.easyvillagers.forge.ModItemGroups;
import de.maxhenkel.easyvillagers.forge.gui.OutputContainer;
import de.maxhenkel.easyvillagers.forge.items.VillagerItem;
import de.maxhenkel.easyvillagers.forge.items.render.IronFarmItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class IronFarmBlock extends VillagerBlockBase implements EntityBlock, IItemBlock {

    public IronFarmBlock() {
        super(Properties.of(Material.METAL).strength(2.5F).sound(SoundType.METAL).noOcclusion());
        setRegistryName(new ResourceLocation(EasyVillagers.MOD_ID, "iron_farm"));
    }

    @Override
    public Item toItem() {
        return new CustomRendererBlockItem(this, new Item.Properties().tab(ModItemGroups.TAB_EASY_VILLAGERS)) {
            @OnlyIn(Dist.CLIENT)
            @Override
            public ItemRenderer createItemRenderer() {
                return new IronFarmItemRenderer();
            }
        }.setRegistryName(getRegistryName());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter blockGetter, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, blockGetter, components, tooltipFlag);
        IronFarmTileentity trader = ItemTileEntityCache.getTileEntity(stack, () -> new IronFarmTileentity(BlockPos.ZERO, ModBlocks.TRADER.defaultBlockState()));
        EasyVillagerEntity villager = trader.getVillagerEntity();
        if (villager != null) {
            components.add(villager.getAdvancedName());
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(handIn);
        BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        if (!(tileEntity instanceof IronFarmTileentity)) {
            return super.use(state, worldIn, pos, player, handIn, hit);
        }
        IronFarmTileentity farm = (IronFarmTileentity) tileEntity;
        if (!farm.hasVillager() && heldItem.getItem() instanceof VillagerItem) {
            farm.setVillager(heldItem.copy());
            ItemUtils.decrItemStack(heldItem, player);
            VillagerBlockBase.playVillagerSound(worldIn, pos, SoundEvents.VILLAGER_NO);
            return InteractionResult.SUCCESS;
        } else if (player.isShiftKeyDown() && farm.hasVillager()) {
            ItemStack stack = farm.removeVillager();
            if (heldItem.isEmpty()) {
                player.setItemInHand(handIn, stack);
            } else {
                if (!player.getInventory().add(stack)) {
                    Direction direction = state.getValue(IronFarmBlock.FACING);
                    Containers.dropItemStack(worldIn, direction.getStepX() + pos.getX() + 0.5D, pos.getY() + 0.5D, direction.getStepZ() + pos.getZ() + 0.5D, stack);
                }
            }
            VillagerBlockBase.playVillagerSound(worldIn, pos, SoundEvents.VILLAGER_CELEBRATE);
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return new TranslatableComponent(state.getBlock().getDescriptionId());
                }

                @Nullable
                @Override
                public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
                    return new OutputContainer(id, playerInventory, farm.getOutputInventory());
                }
            });
            return InteractionResult.SUCCESS;
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level1, BlockState state, BlockEntityType<T> type) {
        return new SimpleBlockEntityTicker<>();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new IronFarmTileentity(blockPos, blockState);
    }


    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public float getShadeBrightness(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 1F;
    }

}
