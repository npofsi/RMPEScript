package pro.npofsi.rmpescript.runtime;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import pro.npofsi.rmpescript.RMPEScript;
import pro.npofsi.rmpescript.broadcast.ForgeEventHandler;
import pro.npofsi.rmpescript.runtime.utils.JavaXJS;

public class JSLoader extends Loader{

    private String script,srcName;
    //private Object ScriptManager= pro.npofsi.rmpescript.runtime.ScriptManager.getInstance();

    public JSLoader(String srcName,String script){
        this.srcName=srcName;
        this.script=script;
    }

    @Override
    public void run(){
        synchronized(ScriptManager.getInstance()){
            this.setName(srcName);
            Context cx = Context.enter();
            try {
                Scriptable scope = cx.initStandardObjects();
//            JavaXJS.JavaToJS(ForgeEventHandler.getInstance(),"ForgeEventHandler",scope);
//            JavaXJS.JavaToJS(RMPEScript.Log.class,"Logger",scope);
//            JavaXJS.JavaToJS(pro.npofsi.rmpescript.,"pro",scope);
//            ((ScriptableObject) scope).defineProperty("EventHandler",pro.npofsi.rmpescript.broadcast.ForgeEventHandler.class, 0);
//            ((ScriptableObject) scope).defineProperty("Logger",RMPEScript.Log.class,1);
                Object result = cx.evaluateString(scope, script, srcName, 1, null);
                RMPEScript.Log.i("Script end: "+cx.toString(result));
            }catch (Exception e) {
                RMPEScript.Log.s(e,"RunTime");
            }finally {
                cx.exit();
            }
        }

    }
}
