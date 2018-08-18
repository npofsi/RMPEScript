package pro.npofsi.rmpescript.runtime;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import pro.npofsi.rmpescript.RMPEScript;
import pro.npofsi.rmpescript.broadcast.ForgeEventHandler;
import pro.npofsi.rmpescript.runtime.utils.JavaXJS;

public class JSLoader extends Loader{

    private String script,srcName;
    private Context cx=null;
//    private Object ScriptManager= pro.npofsi.rmpescript.runtime.ScriptManager.getInstance();

    public JSLoader(String srcName,String script){
        this.srcName=srcName;
        this.script=script;
        this.setName(srcName);
    }

    @Override
    public void run(){
        synchronized(ScriptManager.getInstance()){
            cx = Context.enter();
            try {
                Scriptable scope = cx.initStandardObjects();
                Object result = cx.evaluateString(scope, script, srcName+RMPEScript.randomTag(), 1, null);
                RMPEScript.Log.i("Script end: "+cx.toString(result));
            }catch (Exception e) {
                RMPEScript.Log.s(e,"RunTime");
            }finally {

            }
        }
    }
    public void eval(String code){
        synchronized(ScriptManager.getInstance()){
            if(cx != null)try {
                Scriptable scope = cx.initStandardObjects();
                Object result = cx.evaluateString(scope, code, srcName+RMPEScript.randomTag(), 1, null);
                RMPEScript.Log.i("Script eval end: "+cx.toString(result));
            }catch (Exception e) {
                RMPEScript.Log.s(e,"EvalRunTime");
            }finally {

            }
        }
    }
    public void remove(){
        synchronized(ScriptManager.getInstance()){
            try {
                if(cx!= null)cx.exit();
                this.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
