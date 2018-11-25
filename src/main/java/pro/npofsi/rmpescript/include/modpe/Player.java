package pro.npofsi.rmpescript.include.modpe;

import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class Player {
    private static EntityPlayer currentPlayer;
    public static void setPlayer(EntityPlayer player){
        currentPlayer=player;
    }
    public static EntityPlayer getPlayer(){
        if(currentPlayer==null){
            return currentPlayer;
        }else {
            return null;
        }
    };

    //get position
    public static double getX(){
        return Player.getPlayer().posX;
    }
    public static double getY(){
        return Player.getPlayer().posY;
    }
    public static double getZ(){
        return Player.getPlayer().posZ;
    }

    //get experience
    public static float getExp(){
        return Player.getPlayer().experience;
    }

    //get current level
    public static World getLevel(){
        return Player.getPlayer().world;
    }

    //get camera pitch/yaw
    public static double getPitch(){
        return Player.getPlayer().cameraPitch;
    }
    public static double getYaw(){
        return Player.getPlayer().cameraYaw;
    }

    //get entity
    public static EntityPlayer getEntity(){
        return Player.getPlayer();
    }

    public static void setPosition(double x,double y,double z){
        Player.getPlayer().setPosition(x,y,z);
    }

    public static void setPositionRelative(double x,double y,double z){
        Player.getPlayer().setPosition(getX()+x,getY()+y,getZ()+z);
    }

    public static int getDimension(){
        return Player.getPlayer().dimension;
    }

    public static int getScore(){
        return Player.getPlayer().getScore();
    }
    public static void setHealth(int hp){
        Player.getPlayer().setHealth(hp);
    }

    public static String getInventorySlot(int index){
        return Player.getPlayer().inventory.getStackInSlot(index).getItem().getUnlocalizedName();
    }
    public static int getInventorySlotCount(int index){
        return Player.getPlayer().inventory.getStackInSlot(index).getCount();
    }
    public static int getInventorySlotData(int index){
        return Player.getPlayer().inventory.getStackInSlot(index).getMetadata();
    }
}
