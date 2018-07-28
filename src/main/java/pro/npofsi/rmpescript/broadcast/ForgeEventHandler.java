package pro.npofsi.rmpescript.broadcast;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import pro.npofsi.rmpescript.RMPEScript;
import pro.npofsi.rmpescript.include.modpe.Level;

public class ForgeEventHandler {
    //@EventBusSubscriber(modid=RMPEScript.MODID)

    private ForgeEventHandler(){

    }
    public static ForgeEventHandler getInstance(){
        return ClassHolder.sInstance;
    }
    private static class ClassHolder{
        private static final ForgeEventHandler sInstance = new ForgeEventHandler();
    }

    public static void register(){
        MinecraftForge.EVENT_BUS.register(ForgeEventHandler.getInstance());
    }

    public static void unregister(){
        MinecraftForge.EVENT_BUS.unregister(ForgeEventHandler.getInstance());
    }



    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event){
        //Level.explode(event.getEntityPlayer().posX,event.getEntityPlayer().posY,event.getEntityPlayer().posZ,20);
    }

    @SubscribeEvent
    public void  arrowNocked(ArrowNockEvent event){

    }
}
