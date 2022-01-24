package de.maxhenkel.corelib.config;

import net.minecraftforge.common.ForgeConfigSpec;
//FIXME import net.minecraftforge.fml.event.config.ModConfigEvent;

public class ConfigBase {

    protected ForgeConfigSpec configSpec;

    public ConfigBase(ForgeConfigSpec.Builder builder) {

    }
/* FIXME
    public void onReload(ModConfigEvent event) {

    }
 */
    public void setConfigSpec(ForgeConfigSpec configSpec) {
        this.configSpec = configSpec;
    }

    public ForgeConfigSpec getConfigSpec() {
        return configSpec;
    }
}
