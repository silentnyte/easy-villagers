package de.maxhenkel.easyvillagers.items;

import de.maxhenkel.easyvillagers.EasyVillagers;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
//import net.minecraft.util.Identifier;
//FIXME import net.minecraftforge.event.RegistryEvent;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(EasyVillagers.MOD_ID, Registry.ITEM_REGISTRY);

    //public static VillagerItem VILLAGER = new VillagerItem();
    public static final RegistrySupplier<VillagerItem> VILLAGER2 = ITEMS.register("villager2", () -> new VillagerItem(new Item.Properties().tab(EasyVillagers.DEVELOPMENT_TAB)));

    public static void init() {
        ITEMS.register();
        //Registry.register(Registry.ITEM, new Identifier(EasyVillagers.MOD_ID, "villager"), VILLAGER);
    }
        

/* FIXME
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                VILLAGER.setRegistryName(EasyVillagers.MOD_ID, "villager")
        );
    }
 */
}
