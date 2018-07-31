package pro.npofsi.rmpescript.runtime;

import pro.npofsi.rmpescript.RMPEScript;

import java.lang.*;
import java.util.Iterator;
import java.util.Stack;

public class ScriptManager {

    private ScriptManager(){}
    public static ScriptManager getInstance(){
        return ClassHolder.sInstance;
    }
    private static class ClassHolder{
        private static final ScriptManager sInstance = new ScriptManager();
    }

    Stack<Loader> runstack;
    public String loadScript(String srcName,String script,String lang){
        switch(lang){
            case "js":{
                String name=srcName+RMPEScript.randomId();
                runstack.push(new JSLoader(name,script));
                return name;
            }
            default:{
                RMPEScript.Log.i("Unknow language of script script@variable(check stack)");
                return "";
            }
        }
    }
    public void runScript(){

        for (Iterator<Loader> i=runstack.iterator();i.hasNext();){
            Loader cache=i.next();
            cache.run();
        }
    }
    public void removeScript(String name){
        for (Iterator<Loader> i=runstack.iterator();i.hasNext();){
            Loader cache=i.next();
            if(cache.getName().equals(name))cache.remove();
        }
    }
}
