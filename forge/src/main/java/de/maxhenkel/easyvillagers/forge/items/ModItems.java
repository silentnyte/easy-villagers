package de.maxhenkel.easyvillagers.forge.items;

import de.maxhenkel.easyvillagers.EasyVillagers;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;

public class ModItems {

    public static VillagerItem VILLAGER = new VillagerItem();

    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                VILLAGER.setRegistryName(EasyVillagers.MOD_ID, "villager")
        );
    }

}
