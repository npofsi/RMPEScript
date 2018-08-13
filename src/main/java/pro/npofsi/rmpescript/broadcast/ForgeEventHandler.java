package pro.npofsi.rmpescript.broadcast;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import pro.npofsi.rmpescript.RMPEScript;
import pro.npofsi.rmpescript.include.modpe.Level;

import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class ForgeEventHandler {

    public ForgeEventHandler(){}
    public static ForgeEventHandler getInstance(){
        return ClassHolder.sInstance;
    }
    private static class ClassHolder{
        private static final ForgeEventHandler sInstance = new ForgeEventHandler();
    }

    public void register(){
        MinecraftForge.EVENT_BUS.register(ForgeEventHandler.getInstance());
    }
    public void unregister(){
        MinecraftForge.EVENT_BUS.unregister(ForgeEventHandler.getInstance());
    }

    public interface EventCallback{
        public void call(Event event);
    }
    private Map<String,Stack<EventCallback>> eventStore=new TreeMap<String,Stack<EventCallback>>();
    public void registerCallback(String name,EventCallback callback){
        if(eventStore.get(name)==null) { eventStore.put(name,new Stack<EventCallback>());eventStore.get(name).push(callback); }else{ eventStore.get(name).push(callback); }
    }
    public boolean unregisterCallback(String name,EventCallback callback){
        if(eventStore.get(name)!=null) { return eventStore.get(name).remove(callback); }return false;
    }

//    /* all */
//    @SubscribeEvent
//    public void eventCalled(Event event){
//        Stack<EventCallback> stk=eventStore.get("all");
//        RMPEScript.Log.i("A event happened : <"+event.toString()+">{Cancelable?:"+event.isCancelable()+",Canceled?:"+event.isCanceled()+"}");
//        if(stk != null) for (int i = 0; i < stk.size();i++) stk.elementAt(i).call(event);
//    }

    /* pickupItem */
    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event){
        Stack<EventCallback> stk=eventStore.get("pickupItem");
        if(stk != null) for (int i = 0; i < stk.size();i++) stk.elementAt(i).call(event);
    }

    /* arrowNocked */
    @SubscribeEvent
    public void  arrowNocked(ArrowNockEvent event){
        Stack<EventCallback> stk=eventStore.get("arrowNocked");
        if(stk != null) for (int i = 0; i < stk.size();i++) stk.elementAt(i).call(event);
    }

    /* pickupXp */
    @SubscribeEvent
    public void pickupXp(PlayerPickupXpEvent event) {
        Stack<EventCallback> stk = eventStore.get("pickupXp");
        if (stk != null) for (int i = 0; i < stk.size(); i++) stk.elementAt(i).call(event);
    }

    /* entityAttacked */
    @SubscribeEvent
    public void entityAttacked(AttackEntityEvent event){
        Stack<EventCallback> stk=eventStore.get("entityAttacked");
        if(stk != null) for (int i = 0; i < stk.size();i++) stk.elementAt(i).call(event);

    }
}
