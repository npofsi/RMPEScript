package pro.npofsi.rmpescript.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandInstance extends CommandBase {
    CommandInstance.Callback mCallback;
    String cname="COMMAND_DEFAULT";
    String cusage="No usage!";
    public CommandInstance(String name,String usage,CommandInstance.Callback callback){
        cname=name;
        cusage=usage;
        mCallback=callback;
    }

    @Override
    public String getName() {
        return cname;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return cusage;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        mCallback.execute( server, sender, args);
    }
    public interface Callback{
        void execute(MinecraftServer server, ICommandSender sender, String[] args);
    }
}
