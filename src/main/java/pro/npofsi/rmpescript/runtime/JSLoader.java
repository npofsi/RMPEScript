package pro.npofsi.rmpescript.runtime;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class JSLoader extends Thread {
    private String script,srcName;
    public JSLoader(String srcName,String script){
        this.srcName=srcName;
        this.script=script;
    }

    @Override
    public void run(){
        Context cx = Context.enter();
        Scriptable scope = cx.initStandardObjects();
        Object result = cx.evaluateString(scope, script, srcName, 1, null);
    }
}
