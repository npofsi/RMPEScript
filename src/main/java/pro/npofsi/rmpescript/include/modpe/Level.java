package pro.npofsi.rmpescript.include.modpe;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Level {
    private static World currentWorld;
    public static void setWorld(World world){
        currentWorld=world;
    };
    public static World getWorld(){
        return currentWorld;
    };
    public static void explode(double x, double y, double z, double r, boolean isSmoking){
        Level.getWorld().createExplosion(null,x ,y, z, (float)r, isSmoking);
    }
    public static void explode(double x, double y, double z, double r){
        Level.getWorld().createExplosion(null,x ,y, z, (float)r, true);
    }
    public static void setTile(int x,int y,int z,String id,int data){
        Level.getWorld().setTileEntity(new BlockPos(x, y, z), TileEntity.create(Level.getWorld(),new NBTTagCompound()));
    }
}
