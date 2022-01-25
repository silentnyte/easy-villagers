package de.maxhenkel.easyvillagers;

import com.google.common.base.Suppliers;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.maxhenkel.easyvillagers.items.ModItems;

import java.util.function.Supplier;

public class EasyVillagers {
    public static final String MOD_ID = "easy_villagers";
    public static final Logger LOGGER = LogManager.getLogger(EasyVillagers.MOD_ID);

    public static ServerConfig SERVER_CONFIG;

    // Registering a new creative tab
    public static final CreativeModeTab DEVELOPMENT_TAB = CreativeTabRegistry.create(new ResourceLocation(EasyVillagers.MOD_ID, "development_tab"), () ->
            new ItemStack(ModItems.VILLAGER2.get()));
        
    public static void init() {
        ModItems.init();
        //SERVER_CONFIG = CommonRegistry.registerConfig(ModConfig.Type.SERVER, ServerConfig.class);
        System.out.println(EasyVillagersExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
