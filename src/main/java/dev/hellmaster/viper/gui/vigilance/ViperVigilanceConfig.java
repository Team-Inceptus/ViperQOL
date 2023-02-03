package dev.hellmaster.viper.gui.vigilance;

import com.sun.scenario.effect.Crop;
import dev.hellmaster.viper.api.APIUtils;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import gg.essential.vigilance.gui.VigilancePalette;
import net.minecraft.client.Minecraft;
import java.io.File;

public class ViperVigilanceConfig extends Vigilant {

    public static ViperVigilanceConfig INSTANCE;
    public static boolean awaitShowColourWindow = false;

    public final VigilancePalette getPalette() {
        return VigilancePalette.INSTANCE;
    }

    public final ViperVigilanceConfig getINSTANCE() { return INSTANCE; }

    public final void setINSTANCE(ViperVigilanceConfig var1) { INSTANCE = var1; }

    public static final File modDir = new File(Minecraft.getMinecraft().mcDataDir, "config/ViperVigilanceConfig");

    public static final File configFile = new File(modDir + "/ViperVigilanceConfig.toml");

    public ViperVigilanceConfig() {
        super(configFile, "Viper Config", new ViperPropertyCollector(), new ViperSB());
        this.preload();
        this.writeData();
        modDir.mkdirs();
        this.initialize();
    }

    //DATA

    //Api
    @Property(
            type = PropertyType.TEXT,
            name = "API Key",
            description = "Your Hypixel API key. Automatically configures itself, however if some things don't work then manually updating this may help.",
            category = "API"
    )
    public static String apiKey = "";

    @Property(
            type = PropertyType.SELECTOR,
            name = "API Auto Update Rate",
            description = "Automatically updates the api at the set interval above.",
            category = "API",
            options = {"1 Minute (Not Recommended)", "5 Minutes (Recommended)", "10 Minutes", "30 Minutes", "1 Hour", "Manually"}
    )
    public static int apiRate = 1;

    @Property(
            type = PropertyType.BUTTON,
            name = "Update API",
            description = "Updates the API. API Automatically updates at your set interval, but this manually refreshes the API.",
            category = "API"
    )
    public static void updateAPI() {
        APIUtils.updateAPI();
    }

    @Property(
            type = PropertyType.SWITCH,
            name = "Faster API Updates",
            description = "Updates the API faster, but uses an extra thread.",
            category = "API"
    )
    public static boolean fastAPIUpdates = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Enable API Update messages",
            description = "If the constant spam from the API updating bothers you, then turn this off to disable them! (The API will still update, just silently.",
            category = "API"
    )
    public static boolean doAPIMessage = true;

}
