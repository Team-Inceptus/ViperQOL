package dev.hellmaster.viper.api;

import dev.hellmaster.viper.Viper;
import dev.hellmaster.viper.gui.vigilance.ViperVigilanceConfig;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoKey {

    @SubscribeEvent
    public void setApiKey(ClientChatReceivedEvent event) {

        String msg = event.message.getUnformattedText();
        if (msg.contains("Your new API key is ")) {
            Viper.sendMarkedChatMessage("Automatically configured API key!");
            ViperVigilanceConfig.apiKey = msg.replace("Your new API key is ", "");
        }

    }

}
