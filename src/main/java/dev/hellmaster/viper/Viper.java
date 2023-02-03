package dev.hellmaster.viper;

import dev.hellmaster.viper.api.APIUtils;
import dev.hellmaster.viper.api.AutoKey;
import dev.hellmaster.viper.command.ViperCmd;
import dev.hellmaster.viper.gui.vigilance.ViperVigilanceConfig;
import dev.hellmaster.viper.key.Keybinds;
import dev.hellmaster.viper.proxy.ClientProxy;
import dev.hellmaster.viper.proxy.CommonProxy;
import gg.essential.elementa.effects.StencilEffect;
import gg.essential.universal.UMinecraft;
import gg.essential.universal.UScreen;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = Viper.MODID, version = Viper.VERSION)
public class Viper {
    public static final String MODID = "Viper";
    public static final String VERSION = "0.0.1";
    //used for viper's gui
    public static UScreen gui = null;

    public static Minecraft mc = Minecraft.getMinecraft();

    public static EntityPlayerSP player = mc.thePlayer;

    public static WorldClient world = mc.theWorld;
    //proxy (most likely won't be used)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ViperVigilanceConfig.INSTANCE = new ViperVigilanceConfig();
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        //reduce redundant code
        List<Object> registry = new ArrayList<>();

        //add events to register
        registry.add(new Viper());
        registry.add(new Keybinds());
        registry.add(new AutoKey());
        registry.add(new APIUtils());
        registry.forEach(MinecraftForge.EVENT_BUS::register);

        //Keybinds
        ClientCommandHandler.instance.registerCommand(new ViperCmd());
        ClientProxy.keyBindings = new KeyBinding[1];
        ClientProxy.keyBindings[0] = new KeyBinding("Open Menu", Keyboard.KEY_GRAVE, "Viper QOL");
        for (int i = 0; i < ClientProxy.keyBindings.length; i++) {
            ClientRegistry.registerKeyBinding(ClientProxy.keyBindings[i]);
        }
        StencilEffect.Companion.enableStencil();
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @SubscribeEvent
    public final void tick(TickEvent.ClientTickEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (gui != null) {
            try {
                UMinecraft.getMinecraft().displayGuiScreen(gui);
            } catch (Exception var3) {
                var3.printStackTrace();
            }

            gui = null;
        }

        player = mc.thePlayer;

        world = mc.theWorld;
    }



    public static void sendChatMessage(String message) {
        player.addChatMessage(new ChatComponentText(message));
    }

    public static void sendMarkedChatMessage(String message) {
        player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_GREEN + "[$" + EnumChatFormatting.GOLD + "Viper" + EnumChatFormatting.DARK_GREEN + "$] " + EnumChatFormatting.LIGHT_PURPLE + message));
    }
}
