package pro.npofsi.rmpescript;



import net.minecraft.command.ServerCommandManager;
import net.minecraft.init.Blocks;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;
import pro.npofsi.rmpescript.beta.CommandBoom;
import pro.npofsi.rmpescript.broadcast.ForgeEventHandler;
import pro.npofsi.rmpescript.command.CommandManager;
import pro.npofsi.rmpescript.common.CommonProxy;
import pro.npofsi.rmpescript.data.DataStore;
import pro.npofsi.rmpescript.data.FileOperator;
import pro.npofsi.rmpescript.include.modpe.Level;

@Mod(modid = RMPEScript.MODID, name = RMPEScript.NAME, version = RMPEScript.VERSION, acceptedMinecraftVersions = "[1.11.2,)")
public class RMPEScript {

    public static final String MODID = "rmpescript";
    public static final String NAME = "RMPEScript";
    public static final String VERSION = "1.0.0";

    @Mod.Instance(RMPEScript.MODID)
    public RMPEScript instance;

    @SidedProxy(clientSide = "pro.npofsi.rmpescript.client.ClientProxy",
            serverSide = "pro.npofsi.rmpescript.common.CommonProxy")
    public static CommonProxy proxy;

    public Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //TODO

        Log.setServer(event.getModLog());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        DataStore.getInstance().init();
        ForgeEventHandler.register();
        // some example code
        //logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //TODO
        //

    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        Intent.setServer(event.getServer());
        CommandManager.getInstance().refresh((ServerCommandManager) event.getServer().getCommandManager());

        CommandManager.getInstance().register(new CommandBoom());
        Level.setWorld(event.getServer().getEntityWorld());
    }


    public static class Log{
        private static Logger mLogger;
        public static void setServer(Logger logger){
            mLogger=logger;
        }
        public static Logger getServer(){
            return mLogger;
        }
        public static void e(String error){
            mLogger.error("[RMPEScript] "+error);
        }
        public static void f(String fatal){
            mLogger.fatal("[RMPEScript] "+fatal);
        }
        public static void i(String info)  { mLogger.info("[RMPEScript] "+info);   }
    }

    public static class Intent{
        private static MinecraftServer mServer=null;
        public static void setServer(MinecraftServer server){
            mServer=server;
        }
        public static MinecraftServer getServer(){
            return mServer;
        }
    }
}
