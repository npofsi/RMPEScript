package pro.npofsi.rmpescript.include.modpe;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import pro.npofsi.rmpescript.RMPEScript;

import java.util.Iterator;
import java.util.List;

public class Global {
    public static void clientMessage(String message){
        RMPEScript.Intent.getServer().sendMessage(new TextComponentString(message));
    }
    public static World getLevel(){
        return Level.getWorld();
    }
    public static void setPosition(double x,double y,double z){
        Player.setPosition(x,y,z);
    }

    public static void setPositionRelative(double dx,double dy,double dz){
        Player.setPositionRelative(dx,dy,dz);
    }
    public static EntityPlayer getPlayerEnt(){
        return Player.getEntity();
    }
    public static double getPlayerX(){
        return Player.getX();
    }
    public static double getPlayerY(){
        return Player.getY();
    }
    public static double getPlayerZ(){
        return Player.getZ();
    }
}
