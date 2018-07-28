package pro.npofsi.rmpescript.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/*
* Use in JS:
* CommandManager.register(new CommandInstance( "boom", "/boom <r>", (server,sender,args) => { explode( x, y, z, args[0]) }))
* */

public class CommandManager {
    private ServerCommandManager mscm = null;
    private Stack<ICommand> customRegisteredCommand = new Stack<ICommand>();
    private Map<String,ICommand> allCommands = null;
    public ServerCommandManager refresh(ServerCommandManager scm){
        mscm=scm;
        return scm;
    }
    public Map<String,ICommand> getAllCommands(){
        return mscm.getCommands();
    }
    public Map<String,ICommand> getCustomCommands(){
        Map<String,ICommand> map = new TreeMap<String,ICommand>();
        for(int i=0;i<customRegisteredCommand.size();i++){
            ICommand cmd=customRegisteredCommand.get(i);
            map.put(cmd.getName(),cmd);
        }
        return map;
    }
    public CommandBase register(CommandBase cmdi){
        if(mscm!=null) {
            customRegisteredCommand.push(cmdi);
            mscm.registerCommand(cmdi);
        }
        return cmdi;
    }
    private CommandManager(){

    }
    public static CommandManager getInstance(){
        return ClassHolder.sInstance;
    }
    private static class ClassHolder{
        private static final CommandManager sInstance = new CommandManager();
    }
}
