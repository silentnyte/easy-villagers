package de.maxhenkel.easyvillagers.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.entity.npc.Villager;

@Mixin(Villager.class)
public interface VillagerMixin {

    @Accessor
    boolean getIncreaseProfessionLevelOnUpdate();

    @Accessor
    long getLastRestockGameTime();

    @Accessor("increaseProfessionLevelOnUpdate")
    public void setIncreaseProfessionLevelOnUpdate(boolean increaseProfessionLevelOnUpdate);

    @Invoker("increaseMerchantCareer")
    public void invokeIncreaseMerchantCareer();

    @Invoker("startTrading")
    public void invokeStartTrading(net.minecraft.world.entity.player.Player player);
  

}
