package pro.npofsi.rmpescript.broadcast;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import pro.npofsi.rmpescript.RMPEScript;
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

    //这个统一形式定义的接口导致不能使用rhino所提供的interface的简写形式，会导致rhino找不到相应的类型
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

    private void runCallBack(String eventName,Event event){
        Stack<EventCallback> stk=eventStore.get(eventName);
        if(stk != null) for (int i = 0; i < stk.size();i++) stk.elementAt(i).call(event);
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
    public void pickupItem(EntityItemPickupEvent event){ runCallBack("pickupItem",event); }

    /* arrowNocked */
    @SubscribeEvent
    public void  arrowNocked(ArrowNockEvent event){ runCallBack("arrowNocked",event); }

    /* pickupXp */
    @SubscribeEvent
    public void pickupXp(PlayerPickupXpEvent event) { runCallBack("pickupXp",event); }

    /* entityAttacked */
    @SubscribeEvent
    public void entityAttacked(AttackEntityEvent event){ runCallBack("entityAttacked",event); }

    /* Advencement */
    @SubscribeEvent
    public void advancement(AdvancementEvent event){ runCallBack("entityAttacked",event); }
}
