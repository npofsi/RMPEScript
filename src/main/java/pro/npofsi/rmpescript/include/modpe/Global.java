package pro.npofsi.rmpescript.include.modpe;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import pro.npofsi.rmpescript.RMPEScript;

import java.util.Iterator;
import java.util.List;

public class Global {
    public static void clientMessage(String message){
        List<EntityPlayer> ps=RMPEScript.Intent.getServer().getEntityWorld().playerEntities;
        for(Iterator<EntityPlayer> i=ps.iterator();i.hasNext();){
            i.next().sendMessage(new TextComponentString(message));
        }
    }
}
