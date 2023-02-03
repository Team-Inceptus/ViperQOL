
package dev.hellmaster.viper.command;

import dev.hellmaster.viper.gui.ViperGui;
import dev.hellmaster.viper.Viper;
import dev.hellmaster.viper.gui.vigilance.ViperVigilanceConfig;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class ViperCmd extends CommandBase {

    public String getCommandName() {
        return "viper";
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/viper";
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            Viper.gui = ViperVigilanceConfig.INSTANCE.gui();
        }
    }
}