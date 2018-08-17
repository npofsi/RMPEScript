package pro.npofsi.rmpescript.broadcast;

import net.minecraftforge.fml.common.event.FMLEvent;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class FMLEventHandler {

    //这个统一形式定义的接口导致不能使用rhino所提供的interface的简写形式，会导致rhino找不到相应的类型
    public interface FMLEventCallback{
        public void call(FMLEvent event);
    }
    private static Map<String,Stack<FMLEventCallback>> eventStore=new TreeMap<String,Stack<FMLEventCallback>>();
    public void registerCallback(String name,FMLEventCallback callback){
        if(eventStore.get(name)==null) { eventStore.put(name,new Stack<FMLEventCallback>());eventStore.get(name).push(callback); }else{ eventStore.get(name).push(callback); }
    }
    public boolean unregisterCallback(String name,FMLEventCallback callback){
        if(eventStore.get(name)!=null) { return eventStore.get(name).remove(callback); }return false;
    }
    public static void runCallBack(String eventName,FMLEvent event){
        Stack<FMLEventCallback> stk=eventStore.get(eventName);
        if(stk != null) for (int i = 0; i < stk.size();i++) stk.elementAt(i).call(event);
    }
}
