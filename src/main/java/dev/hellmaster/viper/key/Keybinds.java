package dev.hellmaster.viper.key;

import dev.hellmaster.viper.gui.ViperGui;
import dev.hellmaster.viper.Viper;
import dev.hellmaster.viper.gui.vigilance.ViperVigilanceConfig;
import dev.hellmaster.viper.proxy.ClientProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class Keybinds {

    @SubscribeEvent
    public void onKeyPress(KeyInputEvent event) {

        if (ClientProxy.keyBindings[0].isPressed()) {
            //Viper.gui = new ViperGui();
            Viper.gui = ViperVigilanceConfig.INSTANCE.gui();
        }

    }

}
