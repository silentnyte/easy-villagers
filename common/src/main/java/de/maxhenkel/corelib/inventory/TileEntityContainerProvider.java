package de.maxhenkel.corelib.inventory;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public class TileEntityContainerProvider implements MenuProvider {

    private ContainerCreator container;
    private BlockEntity tileEntity;

    public TileEntityContainerProvider(ContainerCreator container, BlockEntity tileEntity) {
        this.container = container;
        this.tileEntity = tileEntity;
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent(tileEntity.getBlockState().getBlock().getDescriptionId());
    }

    public static void openGui(Player player, BlockEntity tileEntity, ContainerCreator containerCreator) {
        if (player instanceof ServerPlayer) {
            NetworkHooks.openGui((ServerPlayer) player, new TileEntityContainerProvider(containerCreator, tileEntity), packetBuffer -> packetBuffer.writeBlockPos(tileEntity.getBlockPos()));
        }
    }

    @Override
    public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
        return container.create(i, playerInventory, playerEntity);
    }

    public interface ContainerCreator {
        AbstractContainerMenu create(int i, Inventory playerInventory, Player playerEntity);
    }
}
