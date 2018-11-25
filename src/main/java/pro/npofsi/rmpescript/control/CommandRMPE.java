package pro.npofsi.rmpescript.control;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import pro.npofsi.rmpescript.RMPEScript;
import pro.npofsi.rmpescript.runtime.ScriptFileManager;
import pro.npofsi.rmpescript.runtime.ScriptManager;

public class CommandRMPE extends CommandBase {

    @Override
    public String getName() {
        return "rmpe";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/rmpe <operater> [args...]";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        switch (args[0]){
            case "help":{

                break;
            }
            case "init":{
                ScriptFileManager.getInstance().refresh();
                ScriptManager.getInstance().runAllScripts(null);
                break;
            }
            case "run":{
                String label=ScriptManager.getInstance().loadScript("eval_cache",ScriptManager.getInstance().concat(args[1]));
                ScriptManager.getInstance().runScript(label);
                RMPEScript.Intent.getServer().sendMessage(new TextComponentString("Code running in <"+label+">"));
                break;
            }
            case "eval":{
                ScriptManager.getInstance().getLoader(args[1]).eval(args[2]);
            }
            case "status":{
                String[] s=ScriptManager.getInstance().getAllStatus();
                for(int i=0;i<s.length;i++ ) RMPEScript.Intent.getServer().sendMessage(new TextComponentString(s[i]));
                break;
            }
            case "reflect":{
                break;
            }
            default:{

            }
        }
    }
}
