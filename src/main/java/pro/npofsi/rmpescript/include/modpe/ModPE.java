package pro.npofsi.rmpescript.include.modpe;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandTitle;
import pro.npofsi.rmpescript.RMPEScript;
import pro.npofsi.rmpescript.command.CommandSender;

public class ModPE {

    //make a log.
    public static void log(String log){
        RMPEScript.Log.i(log);
    }

    //get user language
    public static String getLanguage(){
        return Minecraft.getMinecraft().gameSettings.language;
    }

    //get version
    public static String getMinecraftVersion(){
        return Minecraft.getMinecraft().getVersion();
    }

    //shutdown
    public static void leaveGame() {
        Minecraft.getMinecraft().shutdown();
    }

    public static void showTipMessage(String message){
        try {
            new CommandTitle().execute(RMPEScript.Intent.getServer(),new CommandSender(),new String[]{"@a","{\"text\":"+message+"}"});
        } catch (CommandException e) {
            RMPEScript.Log.e(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
