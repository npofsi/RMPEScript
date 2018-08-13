package pro.npofsi.rmpescript.control;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import pro.npofsi.rmpescript.runtime.ScriptFileManager;
import pro.npofsi.rmpescript.runtime.ScriptManager;

public class CommandRMPE extends CommandBase {

    @Override
    public String getName() {
        return "rmpe";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "rmpe <operater> [args...]";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        switch (args[0]){
            case "init":{
                ScriptFileManager.getInstance().refresh();
                ScriptManager.getInstance().runAllScripts(null);
                break;
            }
            default:{

            }
        }
    }
}
