package pro.npofsi.rmpescript.include.modpe;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.server.CommandSetBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import pro.npofsi.rmpescript.RMPEScript;
import pro.npofsi.rmpescript.command.CommandSender;

import javax.annotation.Nullable;
import java.util.UUID;

public class Level {
    private static World currentWorld;
    public static void setWorld(World world){
        currentWorld=world;
    }
    public static World getWorld(){
        return currentWorld;
    }

    //BlockLauncher functions

    //make an explosion at [x,y,z] with rad r.
    public static void explode(double x, double y, double z, double r, boolean isSmoking){
        Level.getWorld().createExplosion(null,x ,y, z, (float)r, isSmoking);
    }
    public static void explode(double x, double y, double z, double r){
        Level.getWorld().createExplosion(null,x ,y, z, (float)r, true);
    }

    //
    public static void executeCommand(String command,boolean bl){

    }

    //get game difficulty
    public static int getDifficulty(){
        return Minecraft.getMinecraft().gameSettings.difficulty.getDifficultyId();
    }

    //set a block at [x,y,z]
    public static void setTile(double x,double y,double z,String id,int data) throws CommandException {
        new CommandSetBlock().execute(RMPEScript.Intent.getServer(),new CommandSender(),new String[]{""+(int)x,""+(int)y,""+(int)z,""+id,""+data});
    }

}
