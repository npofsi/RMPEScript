package pro.npofsi.rmpescript.command;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import pro.npofsi.rmpescript.RMPEScript;
import pro.npofsi.rmpescript.include.modpe.Level;

import javax.annotation.Nullable;

public class CommandSender implements ICommandSender {
    @Override
    public String getName(){
        return"RMPEScript";
    }
    @Override
    public boolean canUseCommand(int permLevel,String commandName){
        return true;
    }
    @Override
    public World getEntityWorld(){
        return Level.getWorld();
    }
    @Nullable
    @Override
    public MinecraftServer getServer(){
        return RMPEScript.Intent.getServer();
    }
}
