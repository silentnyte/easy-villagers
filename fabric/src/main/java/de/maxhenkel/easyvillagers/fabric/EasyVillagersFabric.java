package de.maxhenkel.easyvillagers.fabric;

import de.maxhenkel.easyvillagers.EasyVillagers;
import de.maxhenkel.easyvillagers.items.ModItems;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Registry;


public class EasyVillagersFabric implements ModInitializer {

/*             
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(EasyVillagers.MOD_ID, Registry.ITEM_REGISTRY);
    public static final RegistrySupplier<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () ->
            new Item(new Item.Properties().tab(EXAMPLE_TAB)));
 */
    @Override
    public void onInitialize() {
        EasyVillagers.init();
    }
}
