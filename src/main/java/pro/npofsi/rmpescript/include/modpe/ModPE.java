package pro.npofsi.rmpescript.include.modpe;

import net.minecraft.command.CommandException;
import net.minecraft.command.CommandTitle;
import pro.npofsi.rmpescript.RMPEScript;
import pro.npofsi.rmpescript.command.CommandSender;

public class ModPE {
    public static void showTipMessage(String message){
        try {
            new CommandTitle().execute(RMPEScript.Intent.getServer(),new CommandSender(),new String[]{"@a","{\"text\":"+message+"}"});
        } catch (CommandException e) {
            RMPEScript.Log.e(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
