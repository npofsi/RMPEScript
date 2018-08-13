package pro.npofsi.rmpescript.runtime;

import net.minecraft.util.ResourceLocation;
import pro.npofsi.rmpescript.RMPEScript;
import pro.npofsi.rmpescript.data.DataStore;

import javax.annotation.Nullable;
import java.lang.*;
import java.util.*;

public class ScriptManager {

    private ScriptManager(){}
    public static ScriptManager getInstance(){
        return ClassHolder.sInstance;
    }
    private static class ClassHolder{
        private static final ScriptManager sInstance = new ScriptManager();
    }

    Stack<JSLoader> runstack=new Stack<JSLoader>();
    String head="";
    String footer="";
    public Map<String, String> refresh(Map<String,String> scriptSet){
//        String[] meta=DataStore.getInstance().getResourceString("assets/meta.js").split("//SPLIT//");
//        head=meta[0];
//        footer=meta[1];
        runstack.removeAllElements();
        Map<String,String> tid=new TreeMap<String, String>();
        for(String key : scriptSet.keySet()){
            tid.put(key,loadScript(key,scriptSet.get(key)));
            if(scriptSet.get(key)!=null){
                RMPEScript.Log.i("Script <"+key+"> loaded.");
            }else{
                RMPEScript.Log.e("Script <"+key+">[null] load failed.");
            }
        }
        return tid;
    }

    public String loadScript(@Nullable String srcName, String script){
        String name=srcName+RMPEScript.randomTag();
//        script=head+script+footer;
        runstack.push(new JSLoader(name,script));
        return name;
    }
    public void removeScript(String name){
        for (Iterator<JSLoader> i=runstack.iterator();i.hasNext();){
            JSLoader cache=i.next();
            if(cache.getName().equals(name))runstack.remove(cache);
        }
    }
    public JSLoader runScript(String name){
        for (Iterator<JSLoader> i=runstack.iterator();i.hasNext();){
            JSLoader cache=i.next();
            if(cache.getName().equals(name))cache.start();
            return cache;
        }
        return null;
    }
    public Stack<JSLoader> runAllScripts(@Nullable List<String> except){
        for (Iterator<JSLoader> i=runstack.iterator();i.hasNext();){
            JSLoader cache=i.next();
            if(except!=null){
                if(except.indexOf(cache.getName())==-1)cache.start();
            }else {
                cache.run();
            }

        }
        return runstack;
    }

}
